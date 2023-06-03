package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InversionStackTest {

    @Test
    void size() {
        var stack = new InversionStack<>();
        stack.push(1);
        stack.push(1.2);
        stack.push("1.2");

        var size = stack.size();

        assertEquals(size, 3);
    }

    @Test
    void pop() {
        var stack = new InversionStack<>();
        stack.push(1);
        stack.push(1.2);
        stack.push("1.2");

        var result = stack.pop();

        assertEquals(result, "1.2");
        assertEquals(stack.size(), 2);
    }

    @Test
    void push() {
        var stack = new InversionStack<>();
        stack.push(1.2);
        stack.push("1.2");
        stack.push(null);

        var result = stack.pop();

        assertNull(result);
        assertEquals(stack.size(), 2);
    }

    @Test
    void peek() {
        var stack = new InversionStack<>();
        stack.push(1.2);
        stack.push("1.2");
        stack.push(1);

        var result = stack.peek();

        assertEquals(result, 1);
        assertEquals(stack.size(), 3);
    }
}