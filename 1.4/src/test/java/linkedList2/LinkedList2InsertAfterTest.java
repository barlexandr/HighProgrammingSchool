package linkedList2;

public class LinkedList2InsertAfterTest {

    public static void main(String[] args) throws Exception {
        var test = new LinkedList2InsertAfterTest();

        test.insertAfter_ByListEmptyTest();
        test.insertAfter_ByFirstElementTest();
        test.insertAfter_ByListHasOneElementTest();
        test.insertAfter_ByListHasTwoElementTest_addInMiddle();
    }

    void insertAfter_ByListEmptyTest() throws Exception {
        var list = new LinkedList2();

        list.insertAfter(null, new Node(1));

        if (list.head.value != 1 || list.count() != 1 || list.tail.value != 1 || list.head.next != null
                || list.head.prev != null || list.tail.next != null || list.tail.prev != null) {
            throw new Exception("Test insertAfter_ByListEmptyTest failed.");
        } else {
            System.out.println("insertAfter_ByListEmptyTest passed");
        }
    }

    void insertAfter_ByFirstElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(4));

        list.insertAfter(null, new Node(1));

        if (list.head.value != 1 || list.count() != 2 || list.tail.value != 4 || list.head.next.value != 4
                || list.head.prev != null || list.tail.next != null || list.tail.prev.value != 1) {
            throw new Exception("Test insertAfter_ByListEmptyTest failed.");
        } else {
            System.out.println("insertAfter_ByListEmptyTest passed");
        }
    }

    void insertAfter_ByListHasOneElementTest() throws Exception {
        var list = new LinkedList2();
        Node node = new Node(1);
        Node node2 = new Node(10);
        list.addInTail(node);

        list.insertAfter(node, node2);

        if (list.head.value != 1 || list.count() != 2 || list.tail.value != 10 || list.head.next != node2
                || list.head.prev != null || list.tail.next != null || list.tail.prev != node) {
            throw new Exception("Test insertAfter_ByListHasOneElementTest failed.");
        } else {
            System.out.println("insertAfter_ByListHasOneElementTest passed");
        }
    }

    void insertAfter_ByListHasTwoElementTest_addInMiddle() throws Exception {
        var list = new LinkedList2();
        Node node = new Node(1);
        Node node2 = new Node(10);
        Node node3 = new Node(7);
        list.addInTail(node);
        list.addInTail(node2);

        list.insertAfter(node, node3);

        if (list.head.value != 1 || list.count() != 3 || list.tail.value != 10
                || list.head.prev != null || list.tail.next != null
                || list.head.next != node3 || list.tail.prev != node3) {
            throw new Exception("Test insertAfter_ByListHasTwoElementTest_addInMiddle failed.");
        } else {
            System.out.println("insertAfter_ByListHasTwoElementTest_addInMiddle passed");
        }
    }

}
