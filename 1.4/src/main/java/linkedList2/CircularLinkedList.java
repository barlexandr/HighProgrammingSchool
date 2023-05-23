package linkedList2;

import java.util.ArrayList;

public class CircularLinkedList {

    public DummyNodeCircular head;
    public DummyNodeCircular tail;
    int size;

    public CircularLinkedList() {
        this.head = new DummyNodeCircular();
        this.tail = new DummyNodeCircular();
        this.head.next = tail;
        this.tail.prev = head;
        this.size = 0;
    }

    public void addInTail(NodeCircular _item) {
        this.tail.prev.next = _item;
        _item.prev = this.tail.prev;
        _item.next = this.tail;
        this.tail.prev = _item;
        this.size++;
    }

    public NodeCircular find(int _value) {
        var headNode = this.head.next;
        var tailNode = this.tail.prev;
        while (!(headNode instanceof DummyNodeCircular)) {
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

    public ArrayList<NodeCircular> findAll(int _value) {
        ArrayList<NodeCircular> nodes = new ArrayList<>();
        NodeCircular node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        NodeCircular foundNode = this.find(_value);
        if (foundNode != null && foundNode.value == _value) {
            foundNode.prev.next = foundNode.next;
            foundNode.next.prev = foundNode.prev;
            this.size--;
            return true;
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
        this.head.next = this.head;
        this.tail.prev = this.tail;
        this.head.prev = null;
        this.tail.next = null;
        this.size = 0;
    }

    public int count() {
        return size;
    }

    public void insertAfter(NodeCircular _nodeAfter, NodeCircular _nodeToInsert) {
        if (_nodeAfter == null) {
            this.head.next.prev = _nodeToInsert;
            _nodeToInsert.next = this.head.next;
            _nodeToInsert.prev = this.head;
            this.head.next = _nodeToInsert;
        } else {
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeToInsert.next = _nodeAfter.next;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next = _nodeToInsert;
        }
        this.size++;
    }
}

class NodeCircular {
    public int value;
    public NodeCircular next;
    public NodeCircular prev;

    public NodeCircular(int _value) {
        value = _value;
        next = null;
        prev = null;
    }

    public NodeCircular() {
        next = null;
        prev = null;
    }
}

class DummyNodeCircular extends NodeCircular {

    public DummyNodeCircular() {
        super();
    }
}