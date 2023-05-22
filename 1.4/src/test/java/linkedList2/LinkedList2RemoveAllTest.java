package linkedList2;

public class LinkedList2RemoveAllTest {

    public static void main(String[] args) throws Exception {
        var test = new LinkedList2RemoveAllTest();

        test.removeAll_ByListEmptyTest();
        test.removeAll_ByListHasOneElementTest();
        test.removeAll_ByListHasTwoElementTest();
        test.removeAll_ByListHasThreeElementTest();
        test.removeAll_ByListHasThreeElementTest_removeTwoElement();
        test.removeAll_ByListHasThreeElementTest_removeAllElement();

    }

    void removeAll_ByListEmptyTest() throws Exception {
        var list = new LinkedList2();

        list.removeAll(1);

        if (list.count() != 0) {
            throw new Exception("Test removeAll_ByListEmptyTest failed.");
        } else {
            System.out.println("removeAll_ByListEmptyTest passed");
        }
    }

    void removeAll_ByListHasOneElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));

        list.removeAll(1);

        if (list.count() != 0 || list.head != null || list.tail != null) {
            throw new Exception("Test removeAll_ByListHasOneElementTest failed.");
        } else {
            System.out.println("removeAll_ByListHasOneElementTest passed");
        }
    }

    void removeAll_ByListHasTwoElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));

        list.removeAll(24);

        if (list.count() != 1 || list.head.value != 1 || list.tail.value != 1 || list.head.next != null) {
            throw new Exception("Test removeAll_ByListHasTwoElementTest failed.");
        } else {
            System.out.println("removeAll_ByListHasTwoElementTest passed");
        }
    }

    void removeAll_ByListHasThreeElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));
        list.addInTail(new Node(22));

        list.removeAll(22);

        if (list.count() != 2 || list.head.value != 1 || list.head.next.value != 24 || list.tail.value != 24 || list.tail.prev.value != 1) {
            throw new Exception("Test removeAll_ByListHasThreeElementTest failed.");
        } else {
            System.out.println("removeAll_ByListHasThreeElementTest passed");
        }
    }

    void removeAll_ByListHasThreeElementTest_removeTwoElement() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(22));
        list.addInTail(new Node(24));
        list.addInTail(new Node(22));

        list.removeAll(22);

        if (list.count() != 1 || list.head.value != 24 || list.head.next != null || list.tail.value != 24 || list.tail.prev != null) {
            throw new Exception("Test removeAll_ByListHasThreeElementTest_removeTwoElement failed.");
        } else {
            System.out.println("removeAll_ByListHasThreeElementTest_removeTwoElement passed");
        }
    }

    void removeAll_ByListHasThreeElementTest_removeAllElement() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(22));
        list.addInTail(new Node(22));
        list.addInTail(new Node(22));

        list.removeAll(22);

        if (list.count() != 0 || list.head != null || list.tail != null) {
            throw new Exception("Test removeAll_ByListHasThreeElementTest_removeAllElement failed.");
        } else {
            System.out.println("removeAll_ByListHasThreeElementTest_removeAllElement passed");
        }
    }

}
