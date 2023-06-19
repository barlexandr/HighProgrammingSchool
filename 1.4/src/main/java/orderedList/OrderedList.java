package orderedList;

import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        if (v1 instanceof String || v2 instanceof String) {
            String value1;
            String value2;
            try {
                value1 = (v1.toString()).replaceAll("\\s+", "");
                value2 = (v2.toString()).replaceAll("\\s+", "");
            } catch (Exception e) {
                throw new ClassCastException("The data type is not string. Comparison is impossible.");
            }
            int valueOfCompare = value1.compareTo(value2);
            if (valueOfCompare == 0) {
                return valueOfCompare;
            }
            return value1.compareTo(value2) < 0 ?
                    -1 :
                    1;
        }
        if (v1 instanceof Number && v2 instanceof Number) {
            Integer value1;
            Integer value2;
            try {
                value1 = (Integer) v1;
                value2 = (Integer) v2;
            } catch (Exception e) {
                throw new ClassCastException("The data type cannot be cast to a numeric form. Comparison is impossible.");
            }
            if (value1 < value2) {
                return -1;
            }
            if (value1 > value2) {
                return 1;
            }
            return 0;
        }
        throw new ClassCastException("The data type cannot be cast to a numeric or string. Comparison is impossible.");
    }

    public void add(T value) {
        if (this.head == null) {
            this.head = this.tail = new Node<>(value);
            return;
        }
        var temp = this.head;
        while (temp != null) {
            int resultOfCompare = this.compare(value, temp.value);

            // Если по возрастанию и value <= head.value то новый head;
            if (temp == this.head && this._ascending && resultOfCompare != 1
                    || temp == this.head && !this._ascending && resultOfCompare != -1) {
                this.head = new Node<>(value);
                this.head.next = temp;
                temp.prev = this.head;
                break;
            }

            // Если по возрастанию и value > tail.value то новый tail;
            if (temp == this.tail && this._ascending && resultOfCompare == 1
                    || temp == this.tail && !this._ascending && resultOfCompare == -1) {
                this.tail = new Node<>(value);
                this.tail.prev = temp;
                temp.next = this.tail;
                break;
            }

            // Если по возрастанию и value < temp.value, то добавляем перед temp;
            // Создаем ссылку у нового элемента на следующий.
            // Создаем ссылку у нового элемента на предыдущий.
            // Обновляем ссылку у следующего на предыдущий.
            // Обновляем ссылку у предыдущего на следующий.
            if (this._ascending && resultOfCompare != 1
                    || !this._ascending && resultOfCompare != -1) {
                var node = new Node<>(value);
                node.next = temp;
                node.prev = temp.prev;
                temp.prev.next = node;
                temp.prev = node;
                break;
            }

            temp = temp.next;
        }
    }

    public Node<T> find(T val) {
        var node = this.head;

        while (node != null) {
            int resultOfCompare = this.compare(val, node.value);
            // Если по возрастанию и найденное значение меньше.
            // Значит элемента с таким значением нет.
            if (this._ascending && resultOfCompare == -1
                    || !this._ascending && resultOfCompare == 1) {
                return null;
            }
            if (resultOfCompare == 0) {
                return node;
            }
            node = node.next;
        }
        return null; // здесь будет ваш код
    }

    public void delete(T val) {
        Node<T> foundNode = this.find(val);

        if (foundNode == null) {
            return;
        }
        if (foundNode == this.head && foundNode == this.tail) {
            this.head = null;
            this.tail = null;
            return;
        }
        if (foundNode == this.head && foundNode.next == this.tail) {
            this.tail.prev = null;
            this.head = this.tail;
            return;
        }
        if (foundNode == this.head) {
            Node<T> nextHead = this.head.next;
            nextHead.prev = null;
            this.head = nextHead;
            return;
        }
        if (foundNode == this.tail) {
            Node<T> newTail = foundNode.prev;
            newTail.next = null;
            this.tail = newTail;
            return;
        }
        var nextNode = foundNode.next;
        var prevNode = foundNode.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    public void clear(boolean asc) {
        this._ascending = asc;
        this.head = null;
        this.tail = null;
        // здесь будет ваш код
    }

    public int count() {
        var node = this.head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
        // здесь будет ваш код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}