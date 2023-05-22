package linkedList2;

public class LinkedList2FindTest {

    public static void main(String[] args) throws Exception {
        var test = new LinkedList2FindTest();

        test.find_ByListEmptyTest();
        test.find_ByListHasOneElementTest();
        test.find_ByListHasTwoElementTest();
        test.find_ByListHasThreeElementTest();
        test.find_ByListHasFourElementTest();
        test.find_ByListHasFiveElementTest();

    }

    void find_ByListEmptyTest() throws Exception {
        var list = new LinkedList2();

        var result = list.find(1);

        if (result != null) {
            throw new Exception("Test find_ByListEmptyTest failed.");
        } else {
            System.out.println("find_ByListEmptyTest passed");
        }
    }

    void find_ByListHasOneElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));

        var result = list.find(1);

        if (result.value != 1) {
            throw new Exception("Test find_ByListHasOneElementTest failed.");
        } else {
            System.out.println("find_ByListHasOneElementTest passed");
        }
    }

    void find_ByListHasTwoElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));

        var result = list.find(24);

        if (result.value != 24) {
            throw new Exception("Test find_ByListHasTwoElementTest failed.");
        } else {
            System.out.println("find_ByListHasTwoElementTest passed");
        }
    }

    void find_ByListHasThreeElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));
        list.addInTail(new Node(22));

        var result = list.find(24);

        if (result.value != 24) {
            throw new Exception("Test find_ByListHasThreeElementTest failed.");
        } else {
            System.out.println("find_ByListHasThreeElementTest passed");
        }
    }

    void find_ByListHasFourElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));
        list.addInTail(new Node(22));
        list.addInTail(new Node(222));

        var result = list.find(24);

        if (result.value != 24) {
            throw new Exception("Test find_ByListHasFourElementTest failed.");
        } else {
            System.out.println("find_ByListHasFourElementTest passed");
        }
    }

    void find_ByListHasFiveElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));
        list.addInTail(new Node(22));
        list.addInTail(new Node(222));
        list.addInTail(new Node(221));

        var result = list.find(22);

        if (result.value != 22) {
            throw new Exception("Test find_ByListHasFiveElementTest failed.");
        } else {
            System.out.println("find_ByListHasFiveElementTest passed");
        }
    }
}
