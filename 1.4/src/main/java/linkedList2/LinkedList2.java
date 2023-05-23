package linkedList2;

import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node headNode = this.head;
        Node tailNode = this.tail;
        while (headNode != null && tailNode != null) {
            if (headNode.value == _value) {
                return headNode;
            }
            if (tailNode.value == _value) {
                return tailNode;
            }
            headNode = headNode.next;
            tailNode = tailNode.prev;
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
        Node foundNode = this.find(_value);
        if (foundNode != null) {
            if (foundNode == this.head) {
                if (foundNode == this.tail) {
                    this.head = null;
                    this.tail = null;
                    return true;
                }
                if (foundNode.next == this.tail) {
                    this.tail.prev = null;
                    this.head = this.tail;
                    return true;
                }
                Node nextHead = this.head.next;
                nextHead.prev = null;
                this.head = nextHead;
                return true;
            } else {
                if (foundNode == this.tail) {
                    Node newTail = foundNode.prev;
                    newTail.next = null;
                    this.tail = newTail;
                    return true;
                } else {
                    Node nextNode = foundNode.next;
                    Node prevNode = foundNode.prev;
                    nextNode.prev = prevNode;
                    prevNode.next = nextNode;
                    return true;
                }
            }
        }
        return false;
    }

    public void removeAll(int _value) {
        var nodes = this.findAll(_value);
        for (int i = 0; i < nodes.size(); i++) {
            this.remove(_value);
        }
    }

    public void clear() {
        for (Node x = this.head; x != null; ) {
            Node next = x.next;
            x.next = null;
            x.prev = null;
            x = next;
        }
        this.tail = null;
        this.head = null;
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
            _nodeToInsert.prev = null;
            _nodeToInsert.next = this.head;
            if (this.head != null) {
                this.head.prev = _nodeToInsert;
            }
            if (this.tail == null) {
                this.tail = _nodeToInsert;
            }
            this.head = _nodeToInsert;
        } else {
            if (_nodeAfter == this.tail) {
                this.tail = _nodeToInsert;
                this.tail.next = null;
            } else {
                _nodeAfter.next.prev = _nodeToInsert;
            }
            Node next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.next = next;
            _nodeToInsert.prev = _nodeAfter;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
