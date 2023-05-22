package linkedList;

import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node firstFindNodeByValue = this.find(_value);
        if (firstFindNodeByValue != null) {
            if (firstFindNodeByValue == this.head) {
                if (firstFindNodeByValue == this.tail) {
                    this.head = null;
                    this.tail = null;
                    return true;
                }
                this.head = this.head.next != null ?
                        this.head.next :
                        null;
                return true;
            } else {
                if (firstFindNodeByValue == this.tail) {
                    Node penultimateNode = this.head;
                    while (penultimateNode.next != this.tail) {
                        penultimateNode = penultimateNode.next;
                    }
                    this.tail = penultimateNode;
                    penultimateNode.next = null;
                    return true;
                } else {
                    Node node = this.head;
                    while (node.next != firstFindNodeByValue) {
                        node = node.next;
                    }
                    node.next = node.next.next;
                    return true;
                }
            }
        }
        return false;
    }

    public void removeAll(int _value) {
        Node temp = this.head;
        if (temp != null) {
            if (temp == this.tail) {
                this.remove(_value);
            } else {
                while (temp.next != null) {
                    if (temp.value == _value) {
                        this.remove(_value);
                    }
                    temp = temp.next;
                }
                if (temp.value == _value) {
                    this.remove(_value);
                }
            }
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (this.tail == null) {
                this.tail = _nodeToInsert;
            }
        } else {
            Node node = this.head;
            while (node != _nodeAfter) {
                node = node.next;
            }
            if (node.next == null) {
                this.tail = _nodeToInsert;
            }
            _nodeToInsert.next = node.next;
            node.next = _nodeToInsert;
        }
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}