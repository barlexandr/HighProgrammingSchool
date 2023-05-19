package task1;

public class LinkedListFindAllTest {

    public static void main(String[] args) throws Exception {
        LinkedListFindAllTest test = new LinkedListFindAllTest();
        test.findAll_IfListEmptyTest();
        test.findAll_IfListHasOneElementTest();
        test.findAll_IfListHasOneElementNotFindTest();
        test.findAll_IfListHasAnyElementTest();
    }

    void findAll_IfListEmptyTest() throws Exception {
        var list = new LinkedList();
        var result = list.findAll(12);

        if (result.size() != 0) {
            throw new Exception("Test findAll_IfListEmptyTest failed.");
        }
    }

    void findAll_IfListHasOneElementTest() throws Exception {
        var list = new LinkedList();
        list.addInTail(new Node(12));
        var result = list.findAll(12);

        if (result.size() != 1) {
            throw new Exception("Test findAll_IfListHasOneElementTest failed.");
        }
    }

    void findAll_IfListHasOneElementNotFindTest() throws Exception {
        var list = new LinkedList();
        list.addInTail(new Node(15));
        var result = list.findAll(12);

        if (result.size() != 0) {
            throw new Exception("Test findAll_IfListHasOneElementNotFindTest failed.");
        }
    }

    void findAll_IfListHasAnyElementTest() throws Exception {
        var list = LinkedListBuilder.build();
        list.addInTail(new Node(15));
        list.addInTail(new Node(12));
        list.addInTail(new Node(12));
        var result = list.findAll(12);

        if (result.size() != 3) {
            throw new Exception("Test findAll_IfListHasAnyElementTest failed.");
        }
    }
}
