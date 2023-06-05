package queue;

import java.util.Stack;

public class QueueByTwoStack<T> {

    private final Stack<T> stack;
    private final Stack<T> stack2;

    public QueueByTwoStack() {
        this.stack = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(T item) {
        this.stack.push(item);
    }

    public T dequeue() {
        if (this.stack.size() == 0 && this.stack2.size() == 0) {
            return null;
        }
        if (this.stack2.size() != 0) {
            return this.stack2.pop();
        }
        while (this.stack.size() != 0) {
            this.stack2.push(this.stack.pop());
        }

        return this.stack2.pop();
    }

    public int size() {
        return this.stack2.size() + this.stack.size();
    }

}
