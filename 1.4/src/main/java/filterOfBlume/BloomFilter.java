package filterOfBlume;

public class BloomFilter {

    private final int filter_len;
    private int bits;

    public BloomFilter(int f_len) {
        this.filter_len = f_len;
        this.bits = 0;
        // создаём битовый массив длиной f_len ...
    }

    // хэш-функции
    public int hash1(String str1) {
        int hash = 1;
        for (int i = 0; i < str1.length(); i++) {
            hash = Math.abs((str1.charAt(i) + ((hash * 17))) % this.filter_len);
        }
        return hash;
    }

    public int hash2(String str1) {
        int hash = 1;
        for (int i = 0; i < str1.length(); i++) {
            hash = Math.abs((str1.charAt(i) + ((hash * 223))) % this.filter_len);
        }
        return hash;
    }

    public void add(String str1) {
        final int hash1 = this.hash1(str1);
        final int hash2 = this.hash2(str1);
        this.bits = this.bits | (1 << hash1);
        this.bits = this.bits | (1 << hash2);
        // добавляем строку str1 в фильтр
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        final int hash1 = this.hash1(str1);
        final int hash2 = this.hash2(str1);
        return (this.bits & (1 << hash1)) == (1 << hash1)
                && (this.bits & (1 << hash2)) == (1 << hash2);
    }
}
