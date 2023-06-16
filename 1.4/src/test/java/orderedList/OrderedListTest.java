package orderedList;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {

    @Test
    void addIntegerAndStringValue_byDesc_test() {
        var list = new OrderedList<>(false);
        list.add(10);
        list.add(7);
        list.add(15);
        list.add("string");

        final var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(4, list.count());
        assertEquals("[string, 15, 10, 7]", result);
    }

    @Test
    void addStringValue_test() {
        var list = new OrderedList<>(true);
        list.add("string");
        list.add("any string");
        list.add("this");
        list.add("is");

        final var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals("[any string, is, string, this]", result);
    }

    @Test
    void addIntegerValue_byAsc_test() {
        var list = new OrderedList<>(true);
        list.add(10);
        list.add(7);
        list.add(15);
        list.add(11);
        list.add(3);
        list.add(20);

        var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(6, list.count());
        assertEquals("[3, 7, 10, 11, 15, 20]", result);

        list.clear(false);
        list.add(10);
        list.add(7);
        list.add(15);
        list.add(11);
        list.add(3);
        list.add(20);

        result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(6, list.count());
        assertEquals("[20, 15, 11, 10, 7, 3]", result);
    }

    @Test
    void addIntegerValue_byDesc_test() {
        var list = new OrderedList<>(false);
        list.add(10);
        list.add(7);
        list.add(15);
        list.add(11);
        list.add(3);
        list.add(20);

        final var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(6, list.count());
        assertEquals("[20, 15, 11, 10, 7, 3]", result);
    }

    @Test
    void deleteIntegerValue_byAsc_test() {
        var list = new OrderedList<>(true);
        list.add(10);
        list.add(7);
        list.add(15);
        list.add(11);
        list.add(3);
        list.add(20);
        list.delete(7);

        final var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(5, list.count());
        assertEquals(result, "[3, 10, 11, 15, 20]");
    }

    @Test
    void deleteFirstIntegerValue_byAsc_test() {
        var list = new OrderedList<>(true);
        list.add(10);
        list.add(7);
        list.add(3);
        list.add(20);
        list.delete(3);

        final var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(3, list.count());
        assertEquals(result, "[7, 10, 20]");
    }

    @Test
    void deleteAllValue_byAsc_test() {
        var list = new OrderedList<>(true);
        list.add(10);
        list.delete(10);

        final var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(0, list.count());
    }

    @Test
    void deleteLastIntegerValue_byDesc_test() {
        var list = new OrderedList<>(false);
        list.add(10);
        list.add(7);
        list.add(3);
        list.add(20);
        list.delete(3);

        final var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(3, list.count());
        assertEquals(result, "[20, 10, 7]");
    }

    @Test
    void deleteIntegerDuplicateValue_byDesc_test() {
        var list = new OrderedList<>(false);
        list.add(10);
        list.add(7);
        list.add(3);
        list.add(3);
        list.add(20);
        list.delete(3);

        final var result = list.getAll().stream()
                .map(n -> n.value)
                .collect(Collectors.toList())
                .toString();

        assertEquals(4, list.count());
        assertEquals(result, "[20, 10, 7, 3]");
    }
}