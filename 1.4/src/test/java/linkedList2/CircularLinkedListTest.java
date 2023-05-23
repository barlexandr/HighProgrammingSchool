package linkedList2;

class CircularLinkedListTest {

    public static void main(String[] args) throws Exception {
        var test = new CircularLinkedListTest();

        test.find_ByListEmptyTest();
        test.find_ByListHasOneElementTest();
        test.find_ByListHasTwoElementTest();
        test.find_ByListHasThreeElementTest();

        test.findAll_ByListEmptyTest();
        test.findAll_ByListHasOneElementTest();
        test.findAll_ByListHasTwoElementTest();
        test.findAll_ByListHasTwoEqualsElementTest();
        test.findAll_ByListHasThreeElementTest();
        test.findAll_ByListHasThreeEqualsElementTest();

        test.remove_ByListEmptyTest();
        test.remove_ByListHasOneElementTest();
        test.remove_ByListHasTwoElementTest_deletedTail();
        test.remove_ByListHasTwoElementTest_deletedHead();
        test.remove_ByListHasThreeElementTest_deletedMiddle();
        test.remove_ByListHasThreeElementTest_deletedHead();
        test.remove_ByListHasThreeElementTest_deletedTail();

        test.removeAll_ByListEmptyTest();
        test.removeAll_ByListHasOneElementTest();
        test.removeAll_ByListHasTwoElementTest();
        test.removeAll_ByListHasThreeElementTest();
        test.removeAll_ByListHasThreeElementTest_removeTwoElement();
        test.removeAll_ByListHasThreeElementTest_removeAllElement();

        test.insertAfter_ByListEmptyTest();
        test.insertAfter_ByFirstElementTest();
        test.insertAfter_ByListHasOneElementTest();
        test.insertAfter_ByListHasTwoElementTest_addInMiddle();
    }

    void insertAfter_ByListEmptyTest() throws Exception {
        var list = new CircularLinkedList();

        list.insertAfter(null, new NodeCircular(1));

        if (list.head.next.value != 1 || list.count() != 1 || list.tail.prev.value != 1) {
            throw new Exception("Test insertAfter_ByListEmptyTest failed.");
        } else {
            System.out.println("insertAfter_ByListEmptyTest passed");
        }
    }

    void insertAfter_ByFirstElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(4));

        list.insertAfter(null, new NodeCircular(1));

        if (list.head.next.value != 1 || list.count() != 2 || list.tail.prev.value != 4
                || list.head.next.next.value != 4 || list.tail.prev.prev.value != 1) {
            throw new Exception("Test insertAfter_ByListEmptyTest failed.");
        } else {
            System.out.println("insertAfter_ByListEmptyTest passed");
        }
    }

    void insertAfter_ByListHasOneElementTest() throws Exception {
        var list = new CircularLinkedList();
        NodeCircular node = new NodeCircular(1);
        NodeCircular node2 = new NodeCircular(10);
        list.addInTail(node);

        list.insertAfter(node, node2);

        if (list.head.next.value != 1 || list.count() != 2 || list.tail.prev.value != 10
                || list.head.next.next != node2 || list.tail.prev.prev != node) {
            throw new Exception("Test insertAfter_ByListHasOneElementTest failed.");
        } else {
            System.out.println("insertAfter_ByListHasOneElementTest passed");
        }
    }

    void insertAfter_ByListHasTwoElementTest_addInMiddle() throws Exception {
        var list = new CircularLinkedList();
        NodeCircular node = new NodeCircular(1);
        NodeCircular node2 = new NodeCircular(10);
        NodeCircular node3 = new NodeCircular(7);
        list.addInTail(node);
        list.addInTail(node2);

        list.insertAfter(node, node3);

        if (list.head.next.value != 1 || list.count() != 3 || list.tail.prev.value != 10
                || list.head.next.next != node3 || list.tail.prev.prev != node3) {
            throw new Exception("Test insertAfter_ByListHasTwoElementTest_addInMiddle failed.");
        } else {
            System.out.println("insertAfter_ByListHasTwoElementTest_addInMiddle passed");
        }
    }

    void removeAll_ByListEmptyTest() throws Exception {
        var list = new CircularLinkedList();

        list.removeAll(1);

        if (list.count() != 0) {
            throw new Exception("Test removeAll_ByListEmptyTest failed.");
        } else {
            System.out.println("removeAll_ByListEmptyTest passed");
        }
    }

    void removeAll_ByListHasOneElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));

        list.removeAll(1);

        if (list.count() != 0) {
            throw new Exception("Test removeAll_ByListHasOneElementTest failed.");
        } else {
            System.out.println("removeAll_ByListHasOneElementTest passed");
        }
    }

    void removeAll_ByListHasTwoElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));

        list.removeAll(24);

        if (list.count() != 1 || list.head.next.value != 1 || list.tail.prev.value != 1) {
            throw new Exception("Test removeAll_ByListHasTwoElementTest failed.");
        } else {
            System.out.println("removeAll_ByListHasTwoElementTest passed");
        }
    }

    void removeAll_ByListHasThreeElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(22));

        list.removeAll(22);

        if (list.count() != 2 || list.head.next.value != 1 || list.tail.prev.value != 24) {
            throw new Exception("Test removeAll_ByListHasThreeElementTest failed.");
        } else {
            System.out.println("removeAll_ByListHasThreeElementTest passed");
        }
    }

    void removeAll_ByListHasThreeElementTest_removeTwoElement() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(22));
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(22));

        list.removeAll(22);

        if (list.count() != 1 || list.head.next.value != 24 || list.tail.prev.value != 24) {
            throw new Exception("Test removeAll_ByListHasThreeElementTest_removeTwoElement failed.");
        } else {
            System.out.println("removeAll_ByListHasThreeElementTest_removeTwoElement passed");
        }
    }

    void removeAll_ByListHasThreeElementTest_removeAllElement() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(22));
        list.addInTail(new NodeCircular(22));
        list.addInTail(new NodeCircular(22));

        list.removeAll(22);

        if (list.count() != 0) {
            throw new Exception("Test removeAll_ByListHasThreeElementTest_removeAllElement failed.");
        } else {
            System.out.println("removeAll_ByListHasThreeElementTest_removeAllElement passed");
        }
    }

    void remove_ByListEmptyTest() throws Exception {
        var list = new CircularLinkedList();

        var result = list.remove(1);

        if (result) {
            throw new Exception("Test remove_ByListEmptyTest failed.");
        } else {
            System.out.println("remove_ByListEmptyTest passed");
        }
    }

    void remove_ByListHasOneElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));

        var result = list.remove(1);

        if (!result || list.count() != 0) {
            throw new Exception("Test remove_ByListHasOneElementTest failed.");
        } else {
            System.out.println("remove_ByListHasOneElementTest passed");
        }
    }

    void remove_ByListHasTwoElementTest_deletedTail() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));

        var result = list.remove(24);

        if (!result || list.size != 1 || list.head.next.value != 1) {
            throw new Exception("Test remove_ByListHasTwoElementTest_deletedTail failed.");
        } else {
            System.out.println("remove_ByListHasTwoElementTest_deletedTail passed");
        }
    }

    void remove_ByListHasTwoElementTest_deletedHead() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));

        var result = list.remove(1);

        if (!result || list.size != 1 || list.head.next.value != 24) {
            throw new Exception("Test remove_ByListHasTwoElementTest_deletedTail failed.");
        } else {
            System.out.println("remove_ByListHasTwoElementTest_deletedTail passed");
        }
    }

    void remove_ByListHasThreeElementTest_deletedMiddle() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(22));

        var result = list.remove(24);

        if (!result || list.count() != 2 || list.head.next.value != 1) {
            throw new Exception("Test remove_ByListHasThreeElementTest_deletedMiddle failed.");
        } else {
            System.out.println("remove_ByListHasThreeElementTest_deletedMiddle passed");
        }
    }

    void remove_ByListHasThreeElementTest_deletedHead() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(22));

        var result = list.remove(1);

        if (!result || list.count() != 2 || list.head.next.value != 24) {
            throw new Exception("Test remove_ByListHasThreeElementTest_deletedHead failed.");
        } else {
            System.out.println("remove_ByListHasThreeElementTest_deletedHead passed");
        }
    }

    void remove_ByListHasThreeElementTest_deletedTail() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(22));

        var result = list.remove(22);

        if (!result || list.size != 2 || list.head.next.value != 1 || list.tail.prev.value != 24) {
            throw new Exception("Test remove_ByListHasThreeElementTest_deletedTail failed.");
        } else {
            System.out.println("remove_ByListHasThreeElementTest_deletedTail passed");
        }
    }

    void findAll_ByListEmptyTest() throws Exception {
        var list = new CircularLinkedList();

        var result = list.findAll(1);

        if (result.size() != 0) {
            throw new Exception("Test findAll_ByListEmptyTest failed.");
        } else {
            System.out.println("findAll_ByListEmptyTest passed");
        }
    }

    void findAll_ByListHasOneElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));

        var result = list.findAll(1);

        if (result.size() != 1 && result.get(0).value != 1) {
            throw new Exception("Test findAll_ByListHasOneElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasOneElementTest passed");
        }
    }

    void findAll_ByListHasTwoElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));

        var result = list.findAll(24);

        if (result.size() != 1) {
            throw new Exception("Test findAll_ByListHasTwoElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasTwoElementTest passed");
        }
    }

    void findAll_ByListHasTwoEqualsElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(24));

        var result = list.findAll(24);

        if (result.size() != 2) {
            throw new Exception("Test findAll_ByListHasTwoEqualsElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasTwoEqualsElementTest passed");
        }
    }

    void findAll_ByListHasThreeElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(14));

        var result = list.findAll(24);

        if (result.size() != 2) {
            throw new Exception("Test findAll_ByListHasThreeElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasThreeElementTest passed");
        }
    }

    void findAll_ByListHasThreeEqualsElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(24));

        var result = list.findAll(24);

        if (result.size() != 3) {
            throw new Exception("Test findAll_ByListHasThreeEqualsElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasThreeEqualsElementTest passed");
        }
    }

    void find_ByListEmptyTest() throws Exception {
        var list = new CircularLinkedList();

        var result = list.find(1);

        if (result != null) {
            throw new Exception("Test find_ByListEmptyTest failed.");
        } else {
            System.out.println("find_ByListEmptyTest passed");
        }
    }

    void find_ByListHasOneElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));

        var result = list.find(1);

        if (result.value != 1) {
            throw new Exception("Test find_ByListHasOneElementTest failed.");
        } else {
            System.out.println("find_ByListHasOneElementTest passed");
        }
    }

    void find_ByListHasTwoElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));

        var result = list.find(24);

        if (result.value != 24) {
            throw new Exception("Test find_ByListHasTwoElementTest failed.");
        } else {
            System.out.println("find_ByListHasTwoElementTest passed");
        }
    }

    void find_ByListHasThreeElementTest() throws Exception {
        var list = new CircularLinkedList();
        list.addInTail(new NodeCircular(1));
        list.addInTail(new NodeCircular(24));
        list.addInTail(new NodeCircular(22));

        var result = list.find(24);

        if (result.value != 24) {
            throw new Exception("Test find_ByListHasThreeElementTest failed.");
        } else {
            System.out.println("find_ByListHasThreeElementTest passed");
        }
    }

}