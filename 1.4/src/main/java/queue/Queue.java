package queue;

import java.util.*;

public class Queue<T> {

    private final LinkedList<T> queue;

    public Queue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        this.queue.add(item);
    }

    public T dequeue() {
        if (this.queue.size() != 0) {
            var element = this.queue.getFirst();
            this.queue.removeFirst();
            return element;
        }
        return null;
    }

    public int size() {
        return this.queue.size();
    }

    public void ternTheQueue(int elementsToRotate) {
        if (elementsToRotate < 1) {
            throw new IllegalArgumentException("To rotate the queue you need to specify a number greater than 0.");
        }
        for (int i = 0; i < elementsToRotate; i++) {
            var temp = this.queue.getFirst();
            this.queue.removeFirst();
            this.queue.add(temp);
        }
    }

}
