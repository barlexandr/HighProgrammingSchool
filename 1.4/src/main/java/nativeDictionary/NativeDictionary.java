package nativeDictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {

    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
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

    public boolean isKey(String key) {
        var hash = this.hashFun(key);
        if (this.slots[hash] != null && this.slots[hash].equals(key)) {
            return true;
        }
        // возвращает true если ключ имеется,
        // иначе false
        return false;
    }

    public void put(String key, T value) {
        var hash = this.hashFun(key);
        this.slots[hash] = key;
        this.values[hash] = value;
        // гарантированно записываем
        // значение value по ключу key
    }

    public T get(String key) {
        if (this.isKey(key)) {
            var slot = this.hashFun(key);
            return this.values[slot];
        }
        return null;
    }
}