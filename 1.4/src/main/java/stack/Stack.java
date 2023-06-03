package stack;

import java.util.*;
import java.util.regex.Pattern;

public class Stack<T> {

    protected LinkedList<T> stack;

    public Stack() {
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
            var element = this.stack.getLast();
            this.stack.removeLast();
            return element;
        }
        return null;
    }

    /**
     * O(1)
     */
    public void push(T val) {
        this.stack.add(val);
    }

    public T peek() {
        if (this.size() != 0) {
            return this.stack.getLast();
        }
        return null;
    }

    boolean isLineOfBracketsBalanced(String stringOfBrackets) {
        Stack<Character> stack = new Stack<>();
        String regex = "[()]+";
        if (!Pattern.matches(regex, stringOfBrackets)) {
            return false;
        }
        var charArray = stringOfBrackets.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')' && stack.size() != 0) {
                stack.pop();
                continue;
            }
            if (c == ')' && stack.size() == 0) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}