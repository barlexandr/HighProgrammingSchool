package powerSet;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    @Test
    void testOfManyElement() {
        final var setOfManyElement = getPowerSetOfThirtyThousand();
        final var anySet = new PowerSet<Integer>();
        anySet.put(25);
        anySet.put(3987);
        anySet.put(22874);
        anySet.put(10);
        anySet.put(29673);
        anySet.put(180);

        assertTimeout(Duration.ofSeconds(1), () -> setOfManyElement.get(1_000));
        assertTimeout(Duration.ofSeconds(1), () -> setOfManyElement.remove(25_000));
        assertTimeout(Duration.ofSeconds(1), () -> setOfManyElement.intersection(anySet));
        assertTimeout(Duration.ofSeconds(1), () -> setOfManyElement.union(anySet));
        assertTimeout(Duration.ofSeconds(1), () -> setOfManyElement.difference(anySet));
        assertTimeout(Duration.ofSeconds(1), () -> setOfManyElement.isSubset(anySet));
    }

    @Test
    void put_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(3);

        assertEquals(2, set.size());
    }

    @Test
    void remove_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);
        var resultOfRemove1 = set.remove(4);
        var resultOfRemove2 = set.remove(10);

        assertTrue(resultOfRemove1);
        assertFalse(resultOfRemove2);
        assertEquals(2, set.size());
    }

    @Test
    void intersectionEmpty_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);

        final var set2 = new PowerSet<>();
        set2.put(21);
        set2.put(31);
        set2.put(41);

        final var result = set.intersection(set2);

        assertEquals(0, result.size());
    }

    @Test
    void intersectionNotEmpty_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);

        final var set2 = new PowerSet<>();
        set2.put(2);
        set2.put(31);
        set2.put(41);

        final var result = set.intersection(set2);

        assertEquals(1, result.size());
    }

    @Test
    void unionNotEmpty_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);

        final var set2 = new PowerSet<>();
        set2.put(2);
        set2.put(31);
        set2.put(41);

        final var result = set.union(set2);

        assertEquals(5, result.size());
    }

    @Test
    void unionEmpty_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);

        final var set2 = new PowerSet<>();

        final var result = set.union(set2);

        assertEquals(3, result.size());
    }

    @Test
    void differenceEmpty_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);

        final var set2 = new PowerSet<>();
        set2.put(2);
        set2.put(3);
        set2.put(4);

        final var result = set.difference(set2);

        assertEquals(0, result.size());
    }

    @Test
    void differenceNotEmpty_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);

        final var set2 = new PowerSet<>();
        set2.put(4);

        final var result = set.difference(set2);

        assertEquals(2, result.size());
    }

    @Test
    void isSubset_allElementOfParameterInThis_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);
        set.put(5);

        final var set2 = new PowerSet<>();
        set2.put(4);
        set2.put(3);
        set2.put(2);

        final var result = set.isSubset(set2);

        assertTrue(result);
    }

    @Test
    void isSubset_allElementOfThisIncludeInParameter_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);
        set.put(5);

        final var set2 = new PowerSet<>();
        set2.put(4);
        set2.put(3);
        set2.put(2);
        set2.put(5);
        set2.put(6);

        final var result = set.isSubset(set2);

        assertFalse(result);
    }

    @Test
    void isSubset_notAllElementOfParameterIncludeInThis_test() {
        final var set = new PowerSet<>();
        set.put(2);
        set.put(3);
        set.put(4);
        set.put(5);

        final var set2 = new PowerSet<>();
        set2.put(4);
        set2.put(3);

        final var result = set.isSubset(set2);

        assertTrue(result);
    }

    private PowerSet<Integer> getPowerSetOfThirtyThousand() {
        final var set = new PowerSet<Integer>();
        for (int i = 0; i < 30_000; i++) {
            set.put(i);
        }
        return set;
    }

}