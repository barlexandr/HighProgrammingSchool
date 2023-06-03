package stack;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void isLineOfBracketsBalanced() {
        Stack stack = new Stack();
        var result = stack.isLineOfBracketsBalanced("(()((())()))");
        assertTrue(result);

        result = stack.isLineOfBracketsBalanced("(()()(()");
        assertFalse(result);

        result = stack.isLineOfBracketsBalanced("())(");
        assertFalse(result);

        result = stack.isLineOfBracketsBalanced("))((");
        assertFalse(result);

        result = stack.isLineOfBracketsBalanced("((())");
        assertFalse(result);
    }

    @Test
    void sizeWithNoParametrizedTest() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2.0);
        stack.push("element");
        stack.push("element");
        stack.pop();

        int size = stack.size();

        assertEquals(size, 3);
    }

    @Test
    void pop_withNullSizeStack() {
        Stack stack = new Stack();

        var result = stack.pop();

        assertNull(result);
        assertEquals(stack.size(), 0);
    }

    @Test
    void pop_withStack() {
        Stack stack = new Stack();
        stack.push("");

        var result = stack.pop();

        assertEquals(result, "");
        assertEquals(stack.size(), 0);
    }

    @Test
    void push() {
        Stack stack = new Stack();
        stack.push(null);

        var result = stack.pop();

        assertNull(result);
        assertEquals(stack.size(), 0);
    }

    @Test
    void peek() {
        Stack stack = new Stack();
        stack.push(1);

        var result = stack.peek();

        assertEquals(result, 1);
        assertEquals(stack.size(), 1);
    }
}