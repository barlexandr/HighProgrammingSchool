package deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void isPalindrome_test() {
        var deque = new Deque();
        var result1 = deque.isPalindrome("palindrome");
        var result2 = deque.isPalindrome("palilap");
        var result3 = deque.isPalindrome("pa");
        var result4 = deque.isPalindrome("1");
        var result5 = deque.isPalindrome("12");

        assertFalse(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertTrue(result4);
        assertFalse(result5);
    }

    @Test
    void addAndRemoveFront_test() {
        var deque = new Deque<>();
        deque.addFront(1);
        deque.addFront("jz");

        assertEquals(deque.size(), 2);
        assertEquals(deque.removeFront(), "jz");
        assertEquals(deque.size(), 1);
        assertEquals(deque.removeFront(), 1);
        assertEquals(deque.size(), 0);
    }

    @Test
    void addAndRemoveTail_test() {
        var deque = new Deque<>();
        deque.addTail(12);
        deque.addTail("rb26");

        assertEquals(deque.size(), 2);
        assertEquals(deque.removeTail(), "rb26");
        assertEquals(deque.size(), 1);
        assertEquals(deque.removeTail(), 12);
        assertEquals(deque.size(), 0);
    }

}