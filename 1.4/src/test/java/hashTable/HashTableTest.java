package hashTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hashFun() {
        var hashTable = new HashTable(17, 3);

        var res1 = hashTable.hashFun("string");
        var res12 = hashTable.hashFun("string");
        var res13 = hashTable.hashFun("string");

        assertEquals(res1, res12);
        assertEquals(res1, res13);
    }

    @Test
    void seekSlot() {
        var hashTable = new HashTable(17, 3);

        var slot1 = hashTable.seekSlot("string");
        hashTable.put("string");
        var slot2 = hashTable.seekSlot("string");
        var slot3 = hashTable.seekSlot("string");
    }

    @Test
    void put() {
        var hashTable = new HashTable(17, 3);

        var slot1 = hashTable.seekSlot("string");
        var slot10 = hashTable.seekSlot("stri21ng");
        var slot11 = hashTable.seekSlot("stri21ng12");
        var result1 = hashTable.put("string");
        var slot2 = hashTable.seekSlot("string");
        var result2 = hashTable.put("string");
        var slot3 = hashTable.seekSlot("string");

        assertEquals(result1, 16);
        assertEquals(result2, 16);
    }

    @Test
    void putManyElements() {
        var hashTable = new HashTable(17, 3);

        var result1 = hashTable.put("string");
        var result2 = hashTable.put("strings");
        var result3 = hashTable.put("asdq2w");
        var result4 = hashTable.put("zxsdb123");
        var result5 = hashTable.put("qweasd12");
        var result6 = hashTable.put("sdgsdg");
        var result7 = hashTable.put("sbxvbcv");
        var result8 = hashTable.put("sdfqwer");
        var result9 = hashTable.put("sadf arwege 21");
        var result10 = hashTable.put("1231541");
        var result11 = hashTable.put("sfg wer");
        var result12 = hashTable.put("wqeqw23");
        var result13 = hashTable.put("124124 dsfds");
        var result14 = hashTable.put("lkasjdas897");
        var result15 = hashTable.put("asdqwexvbncb");
        var result16 = hashTable.put("vbcncvjdyf");
        var result17 = hashTable.put("rthxdhgc");
        var result18 = hashTable.put("terhfgdhx");
        var result19 = hashTable.put("thsrthscvb");
        var result20 = hashTable.put("xzvvasdfg");

        var find1 = hashTable.find("string");
        var find2 = hashTable.find("strings");
        var find3 = hashTable.find("asdq2w");
        var find4 = hashTable.find("zxsdb123");
        var find5 = hashTable.find("qweasd12");
        var find6 = hashTable.find("sdgsdg");
        var find7 = hashTable.find("sbxvbcv");
        var find8 = hashTable.find("sdfqwer");
        var find9 = hashTable.find("sadf arwege 21");
        var find10 = hashTable.find("1231541");
        var find11 = hashTable.find("sfg wer");
        var find12 = hashTable.find("wqeqw23");
        var find13 = hashTable.find("124124 dsfds");
        var find14 = hashTable.find("lkasjdas897");
        var find15 = hashTable.find("asdqwexvbncb");
        var find16 = hashTable.find("vbcncvjdyf");
        var find17 = hashTable.find("rthxdhgc");
        var find18 = hashTable.find("terhfgdhx");
        var find19 = hashTable.find("thsrthscvb");
        var find20 = hashTable.find("xzvvasdfg");

        assertEquals(result1, find1);
        assertEquals(result2, find2);
        assertEquals(result3, find3);
        assertEquals(result4, find4);
        assertEquals(result5, find5);
        assertEquals(result6, find6);
        assertEquals(result7, find7);
        assertEquals(result8, find8);
        assertEquals(result9, find9);
        assertEquals(result10, find10);
        assertEquals(result11, find11);
        assertEquals(result12, find12);
        assertEquals(result13, find13);
        assertEquals(result14, find14);
        assertEquals(result15, find15);
        assertEquals(result16, find16);
        assertEquals(result17, find17);
        assertEquals(result18, find18);
        assertEquals(result19, find19);
        assertEquals(result20, find20);
    }

    @Test
    void find() {
        var hashTable = new HashTable(17, 3);
        var put = hashTable.put("string");
        var findVar = hashTable.find("string");

        assertEquals(put, findVar);
    }
}