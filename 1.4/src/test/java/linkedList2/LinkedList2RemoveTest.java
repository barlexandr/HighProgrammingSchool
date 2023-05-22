package linkedList2;

public class LinkedList2RemoveTest {

    public static void main(String[] args) throws Exception {
        var test = new LinkedList2RemoveTest();

        test.remove_ByListEmptyTest();
        test.remove_ByListHasOneElementTest();
        test.remove_ByListHasTwoElementTest_deletedTail();
        test.remove_ByListHasTwoElementTest_deletedHead();
        test.remove_ByListHasThreeElementTest_deletedMiddle();
        test.remove_ByListHasThreeElementTest_deletedHead();
        test.remove_ByListHasThreeElementTest_deletedTail();

    }

    void remove_ByListEmptyTest() throws Exception {
        var list = new LinkedList2();

        var result = list.remove(1);

        if (result) {
            throw new Exception("Test remove_ByListEmptyTest failed.");
        } else {
            System.out.println("remove_ByListEmptyTest passed");
        }
    }

    void remove_ByListHasOneElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));

        var result = list.remove(1);

        if (!result || list.head != null || list.tail != null) {
            throw new Exception("Test remove_ByListHasOneElementTest failed.");
        } else {
            System.out.println("remove_ByListHasOneElementTest passed");
        }
    }

    void remove_ByListHasTwoElementTest_deletedTail() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));

        var result = list.remove(24);

        if (!result || list.head.value != 1 || list.tail.value != 1 || list.head.next != null) {
            throw new Exception("Test remove_ByListHasTwoElementTest_deletedTail failed.");
        } else {
            System.out.println("remove_ByListHasTwoElementTest_deletedTail passed");
        }
    }

    void remove_ByListHasTwoElementTest_deletedHead() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));

        var result = list.remove(1);

        if (!result || list.head.value != 24 || list.tail.value != 24 || list.head.next != null) {
            throw new Exception("Test remove_ByListHasTwoElementTest_deletedTail failed.");
        } else {
            System.out.println("remove_ByListHasTwoElementTest_deletedTail passed");
        }
    }

    void remove_ByListHasThreeElementTest_deletedMiddle() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));
        list.addInTail(new Node(22));

        var result = list.remove(24);

        if (!result || list.head.value != 1 || list.head.next.value != 22 || list.tail.value != 22 || list.tail.prev.value != 1) {
            throw new Exception("Test remove_ByListHasThreeElementTest_deletedMiddle failed.");
        } else {
            System.out.println("remove_ByListHasThreeElementTest_deletedMiddle passed");
        }
    }

    void remove_ByListHasThreeElementTest_deletedHead() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));
        list.addInTail(new Node(22));

        var result = list.remove(1);

        if (!result || list.head.value != 24 || list.head.next.value != 22 || list.tail.value != 22 || list.tail.prev.value != 24) {
            throw new Exception("Test remove_ByListHasThreeElementTest_deletedHead failed.");
        } else {
            System.out.println("remove_ByListHasThreeElementTest_deletedHead passed");
        }
    }

    void remove_ByListHasThreeElementTest_deletedTail() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));
        list.addInTail(new Node(22));

        var result = list.remove(22);

        if (!result || list.head.value != 1 || list.head.next.value != 24 || list.tail.value != 24 || list.tail.prev.value != 1) {
            throw new Exception("Test remove_ByListHasThreeElementTest_deletedTail failed.");
        } else {
            System.out.println("remove_ByListHasThreeElementTest_deletedTail passed");
        }
    }

}
