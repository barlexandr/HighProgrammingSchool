package linkedList;

public class LinkedListInsertAfterTest {

    public static void main(String[] args) throws Exception {
        LinkedListInsertAfterTest test = new LinkedListInsertAfterTest();
        test.insertAfter_IfListEmptyTest();
        test.insertAfter_IfListSizeIsOneTest();
        test.insertAfter_IfListHaveTwoElementTest();
    }

    void insertAfter_IfListEmptyTest() throws Exception {
        var list = new LinkedList();
        list.insertAfter(null, new Node(10));

        if (list.count() != 1) {
            throw new Exception("Test insertAfter_IfListEmptyTest failed.");
        } else {
            System.out.println("insertAfter_IfListEmptyTest passed");
        }
    }

    void insertAfter_IfListSizeIsOneTest() throws Exception {
        var list = new LinkedList();
        var node = new Node(12);
        var insertNode = new Node(145);
        list.addInTail(node);
        list.insertAfter(node, insertNode);

        if (list.count() != 2 && list.head != node && list.tail != insertNode) {
            throw new Exception("Test insertAfter_IfListSizeIsOneTest failed.");
        } else {
            System.out.println("insertAfter_IfListSizeIsOneTest passed");
        }
    }

    void insertAfter_IfListHaveTwoElementTest() throws Exception {
        var list = new LinkedList();
        var node = new Node(12);
        var nodeTwo = new Node(120);
        var insertNode = new Node(145);
        list.addInTail(node);
        list.addInTail(nodeTwo);
        list.insertAfter(node, insertNode);

        if (list.count() != 3 && list.head != node && list.tail != nodeTwo) {
            throw new Exception("Test insertAfter_IfListHaveTwoElementAtThisValueTest failed.");
        } else {
            System.out.println("insertAfter_IfListHaveTwoElementTest passed");
        }
    }
}
