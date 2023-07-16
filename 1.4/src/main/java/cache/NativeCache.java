package cache;

import java.lang.reflect.Array;

class NativeCache<T> {

    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;
    private final int step = 3;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        this.slots = new String[size];
        this.hits = new int[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        var arrayOfValue = key.toCharArray();
        var p = 65;

        int h = 0, a = 7, b = 31;
        for (char c : arrayOfValue) {
            int x = Math.abs(c - 'a' + 1);
            h = Math.abs((h + ((a * x + b) % p)) % this.size);
        }
        return h;
    }

    public void put(String key, T value) {
        var slot = this.seekSlot(key);
        if (slot == -1) {
            int indexElementIfMinHits = this.getIndexOfMinHits();
            this.hits[indexElementIfMinHits] = 0;
            this.slots[indexElementIfMinHits] = key;
            this.values[indexElementIfMinHits] = value;
        }
        if (slot != -1) {
            this.slots[slot] = key;
            this.values[slot] = value;
        }
    }

    public T get(String key) {
        var slot = this.seekSlot(key);
        if (slot != -1) {
            this.hits[slot] += 1;
            return this.values[slot];
        }
        return null;
    }

    private int seekSlot(String key) {
        int hash = this.hashFun(key);
        int count = 0;
        while (this.slots[hash] != null) {
            if (this.slots[hash].equals(key)) {
                break;
            }
            hash += this.step;
            if (hash >= this.size) {
                hash %= this.size;
            }
            count++;
            if (count >= 200) {
                hash = -1;
                break;
            }
        }
        return hash;
    }

    private int getIndexOfMinHits() {
        int min = this.hits[0];
        int indexOfMinElement = 0;
        for (int i = 0; i < this.hits.length; i++) {
            if (this.hits[i] < min) {
                min = this.hits[i];
                indexOfMinElement = i;
            }
        }
        return indexOfMinElement;
    }
}
