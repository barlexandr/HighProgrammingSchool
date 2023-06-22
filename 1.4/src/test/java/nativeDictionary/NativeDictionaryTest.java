package nativeDictionary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void putAndGetRewriteKey_test() {
        var map = new NativeDictionary<>(10, String.class);

        map.put("my first key", "my 1 value");
        map.put("my second key", "my 2 value");
        map.put("my third key", "my 3 value");
        map.put("my four key", "my 4 value");
        map.put("my five key", "my 5 value");
        map.put("my six key", "my 6 value");
        map.put("my seven key", "my 7 value");
        map.put("my eight key", "my 8 value");
        map.put("my nine key", "my 9 value");
        map.put("my ten key", "my 10 value");
        map.put("my ten key", "my new 10 value");

        var result1 = map.get("my four key");
        var result2 = map.get("my five key");
        var result3 = map.get("my six key");
        var result4 = map.get("my seven key");
        var result5 = map.get("my nine key");
        var result6 = map.get("my ten key");

        assertEquals(result1, "my 4 value");
        assertEquals(result2, "my 5 value");
        assertEquals(result3, "my 6 value");
        assertEquals(result4, "my 7 value");
        assertEquals(result5, "my 9 value");
        assertEquals(result6, "my new 10 value");
    }

    @Test
    void getByKeyHasNot_test() {
        var map = new NativeDictionary<>(10, String.class);

        map.put("my first key", "my 1 value");
        map.put("my second key", "my 2 value");
        map.put("my third key", "my 3 value");
        map.put("my four key", "my 4 value");
        map.put("my five key", "my 5 value");
        map.put("my six key", "my 6 value");
        map.put("my seven key", "my 7 value");
        map.put("my eight key", "my 8 value");
        map.put("my nine key", "my 9 value");
        map.put("my ten key", "my 10 value");
        map.put("my ten key", "my new 10 value");

        var result = map.get("my first key");

        assertNull(result);
    }
}