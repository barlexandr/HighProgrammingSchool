package hashTable;

public class HashTable {

    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        this.size = sz;
        this.step = stp;
        this.slots = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            slots[i] = null;
        }
    }

    public int hashFun(String value) {
        var arrayOfValue = value.toCharArray();
        var p = 131;

        int h = 0, a = 7, b = 65;
        for (char c : arrayOfValue) {
            int x = Math.abs(c - 'a' + 1);
            h = Math.abs((h + ((a * x + b) % p)) % this.size);
        }
        return h;
    }

    public int seekSlot(String value) {
        int hash = this.hashFun(value);
        int count = 0;
        while (this.slots[hash] != null) {
            if (this.slots[hash].equals(value)) {
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
        // находит индекс пустого слота для значения, или -1
        return hash;
    }

    public int put(String value) {
        int indexSlot = seekSlot(value);
        if (indexSlot != -1) {
            this.slots[indexSlot] = value;
        }
        // записываем значение по хэш-функции

        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return indexSlot;
    }

    public int find(String value) {
        var slot = this.seekSlot(value);
        if (slot == -1 || this.slots[slot] != null && this.slots[slot].equals(value)) {
            return slot;
        }
        // находит индекс слота со значением, или -1
        return -1;
    }
}
