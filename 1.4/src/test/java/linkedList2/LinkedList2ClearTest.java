package linkedList2;

public class LinkedList2ClearTest {

    public static void main(String[] args) throws Exception {
        var test = new LinkedList2ClearTest();

        test.clear_ByListEmptyTest();
        test.clear_ByListHasOneElementTest();
        test.clear_ByListHasAnyElementsTest();
    }

    void clear_ByListEmptyTest() throws Exception {
        var list = new LinkedList2();

        list.clear();

        if (list.tail != null || list.head != null || list.count() != 0) {
            throw new Exception("Test clear_ByListEmptyTest failed.");
        } else {
            System.out.println("clear_ByListEmptyTest passed");
        }
    }

    void clear_ByListHasOneElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));

        list.clear();

        if (list.tail != null || list.head != null || list.count() != 0) {
            throw new Exception("Test clear_ByListHasOneElementTest failed.");
        } else {
            System.out.println("clear_ByListHasOneElementTest passed");
        }
    }

    void clear_ByListHasAnyElementsTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(22));

        list.clear();

        if (list.tail != null || list.head != null || list.count() != 0) {
            throw new Exception("Test clear_ByListHasAnyElementsTest failed.");
        } else {
            System.out.println("clear_ByListHasAnyElementsTest passed");
        }
    }

}
