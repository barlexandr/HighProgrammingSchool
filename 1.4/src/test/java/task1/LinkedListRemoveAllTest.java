package task1;

public class LinkedListRemoveAllTest {

    public static void main(String[] args) throws Exception {
        LinkedListRemoveAllTest test = new LinkedListRemoveAllTest();
        test.removeAll_IfListEmptyTest();
        test.removeAll_IfListSizeIsOneTest();
        test.removeAll_IfListHaveTwoElementAtThisValueTest();
        test.removeAll_IfListHaveTwoElementAtValueTest();
    }

    void removeAll_IfListEmptyTest() throws Exception {
        var list = new LinkedList();
        list.removeAll(12);

        if (list.head != null && list.tail != null) {
            throw new Exception("Test removeAll_IfListEmptyTest failed.");
        } else {
            System.out.println("removeAll_IfListEmptyTest passed");
        }
    }

    void removeAll_IfListSizeIsOneTest() throws Exception {
        var list = new LinkedList();
        list.addInTail(new Node(12));
        list.removeAll(12);

        if (list.head != null && list.tail != null) {
            throw new Exception("Test removeAll_IfListEmptyTest failed.");
        } else {
            System.out.println("removeAll_IfListSizeIsOneTest passed");
        }
    }

    void removeAll_IfListHaveTwoElementAtThisValueTest() throws Exception {
        var list = LinkedListBuilder.build();
        list.addInTail(new Node(12));
        list.removeAll(12);

        Node temp = list.head;
        while (temp != null) {
            if (temp.value == 12) {
                throw new Exception("Test removeAll_IfListHaveTwoElementAtThisValueTest failed.");
            }
            temp = temp.next;
        }
        System.out.println("removeAll_IfListHaveTwoElementAtThisValueTest passed");

    }

    void removeAll_IfListHaveTwoElementAtValueTest() throws Exception {
        var list = new LinkedList();
        list.addInTail(new Node(12));
        list.addInTail(new Node(12));
        list.removeAll(12);

        Node temp = list.head;
        while (temp != null) {
            if (temp.value == 12) {
                throw new Exception("Test removeAll_IfListHaveTwoElementAtValueTest failed.");
            }
            temp = temp.next;
        }
        System.out.println("removeAll_IfListHaveTwoElementAtValueTest passed");

    }
}
