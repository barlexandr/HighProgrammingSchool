package stack;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class InversionStack<T> {

    protected LinkedList<T> stack;

    public InversionStack() {
        this.stack = new LinkedList<>();
    }

    public int size() {
        return stack.size();
    }

    /**
     * O(1)
     */
    public T pop() {
        if (this.size() != 0) {
            var element = this.stack.getFirst();
            this.stack.removeFirst();
            return element;
        }
        return null;
    }

    /**
     * O(1)
     */
    public void push(T val) {
        this.stack.addFirst(val);
    }

    public T peek() {
        if (this.size() != 0) {
            return this.stack.getFirst();
        }
        return null;
    }
}