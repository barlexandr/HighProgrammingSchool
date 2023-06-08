package deque;

import java.util.*;

public class Deque<T> {

    private final LinkedList<T> deque;

    public Deque() {
        this.deque = new LinkedList<>();
    }

    public void addFront(T item) {
        this.deque.addFirst(item);
    }

    public void addTail(T item) {
        this.deque.addLast(item);
    }

    public T removeFront() {
        if (this.deque.size() != 0) {
            var element = this.deque.getFirst();
            this.deque.removeFirst();
            return element;
        }
        return null;
    }

    public T removeTail() {
        if (this.deque.size() != 0) {
            var element = this.deque.getLast();
            this.deque.removeLast();
            return element;
        }
        return null;
    }

    public int size() {
        return deque.size();
    }

    public boolean isPalindrome(String inputString) {
        if (inputString.length() < 2) {
            return true;
        }
        var array = inputString.toCharArray();
        var deque = new Deque<Character>();
        for (char c : array) {
            deque.addTail(c);
        }
        for (int i = 0; i < deque.size(); i++) {
            var tail = deque.removeTail();
            var front = deque.removeFront();
            if (tail != front) {
                return false;
            }
            if (deque.size() == 1) {
                return true;
            }
        }
        return false;
    }
}