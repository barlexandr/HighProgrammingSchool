package linkedList2;

public class LinkedList2FindAllTest {

    public static void main(String[] args) throws Exception {
        var test = new LinkedList2FindAllTest();

        test.findAll_ByListEmptyTest();
        test.findAll_ByListHasOneElementTest();
        test.findAll_ByListHasTwoElementTest();
        test.findAll_ByListHasTwoEqualsElementTest();
        test.findAll_ByListHasThreeElementTest();
        test.findAll_ByListHasThreeEqualsElementTest();

    }

    void findAll_ByListEmptyTest() throws Exception {
        var list = new LinkedList2();

        var result = list.findAll(1);

        if (result.size() != 0) {
            throw new Exception("Test findAll_ByListEmptyTest failed.");
        } else {
            System.out.println("findAll_ByListEmptyTest passed");
        }
    }

    void findAll_ByListHasOneElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));

        var result = list.findAll(1);

        if (result.size() != 1 && result.get(0).value != 1) {
            throw new Exception("Test findAll_ByListHasOneElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasOneElementTest passed");
        }
    }

    void findAll_ByListHasTwoElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(24));

        var result = list.findAll(24);

        if (result.size() != 1) {
            throw new Exception("Test findAll_ByListHasTwoElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasTwoElementTest passed");
        }
    }

    void findAll_ByListHasTwoEqualsElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(24));
        list.addInTail(new Node(24));

        var result = list.findAll(24);

        if (result.size() != 2) {
            throw new Exception("Test findAll_ByListHasTwoEqualsElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasTwoEqualsElementTest passed");
        }
    }

    void findAll_ByListHasThreeElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(24));
        list.addInTail(new Node(24));
        list.addInTail(new Node(14));

        var result = list.findAll(24);

        if (result.size() != 2) {
            throw new Exception("Test findAll_ByListHasThreeElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasThreeElementTest passed");
        }
    }

    void findAll_ByListHasThreeEqualsElementTest() throws Exception {
        var list = new LinkedList2();
        list.addInTail(new Node(24));
        list.addInTail(new Node(24));
        list.addInTail(new Node(24));

        var result = list.findAll(24);

        if (result.size() != 3) {
            throw new Exception("Test findAll_ByListHasThreeEqualsElementTest failed.");
        } else {
            System.out.println("findAll_ByListHasThreeEqualsElementTest passed");
        }
    }
}
