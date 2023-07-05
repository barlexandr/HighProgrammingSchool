package filterOfBlume;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    @Test
    void test() {
        final var bloom = new BloomFilter(32);

        bloom.add("0123456789");
        bloom.add("1234567890");
        bloom.add("2345678901");
        bloom.add("3456789012");
        bloom.add("4567890123");
        bloom.add("5678901234");
        bloom.add("6789012345");
        bloom.add("7890123456");
        bloom.add("8901234567");
        bloom.add("9012345678");

        final var result1 = bloom.isValue("0123456789");
        final var result2 = bloom.isValue("1234567890");
        final var result3 = bloom.isValue("2345678901");
        final var result4 = bloom.isValue("3456789012");
        final var result5 = bloom.isValue("4567890123");
        final var result6 = bloom.isValue("5678901234");
        final var result7 = bloom.isValue("6789012345");
        final var result8 = bloom.isValue("7890123456");
        final var result9 = bloom.isValue("8901234567");
        final var result10 = bloom.isValue("9012345678");
        final var result11 = bloom.isValue("string");
        final var result12 = bloom.isValue("stringa");
        final var result13 = bloom.isValue("anfytekjhsy");

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertTrue(result5);
        assertTrue(result6);
        assertTrue(result7);
        assertTrue(result8);
        assertTrue(result9);
        assertTrue(result10);
        assertFalse(result11);
        assertFalse(result12);
        assertFalse(result13);
    }

}