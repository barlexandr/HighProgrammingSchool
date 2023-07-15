package cache;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NativeCacheTest {

    @Test
    void put() {
        var cache = new NativeCache<String>(10, String.class);

        cache.put("key", "slot");
        cache.put("key1", "slot");
        cache.put("key2", "slot");
        cache.put("key3", "slot");
        cache.put("key4", "slot");
        cache.put("key5", "slot");
        cache.put("key6", "slot");
        cache.put("key7", "slot");
        cache.put("key8", "slot");
        cache.put("key9", "slot");

        cache.get("key");
        cache.get("key1");
        cache.get("key2");
        cache.get("key3");
        cache.get("key4");
        cache.get("key5");
        cache.get("key6");
        cache.get("key7");
        cache.get("key8");
        cache.get("key");

        cache.get("key1");
        cache.get("key2");
        cache.get("key3");
        cache.get("key4");
        cache.get("key5");
        cache.get("key6");
        cache.get("key7");
        cache.get("key8");

        cache.get("key9");

        cache.put("new key", "haha slot");

        assertEquals(Arrays.toString(cache.hits), "[2, 2, 2, 2, 2, 2, 2, 0, 2, 2]");
        assertEquals(cache.get("new key"), "haha slot");
        assertNull(cache.get("key9"));
    }
}