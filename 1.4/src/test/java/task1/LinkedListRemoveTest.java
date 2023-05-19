package task1;

public class LinkedListRemoveTest {

    public static void main(String[] args) throws Exception {
        LinkedListRemoveTest test = new LinkedListRemoveTest();
        test.removeFirstElementByListTest();
        test.removeSecondElementByListTest();
        test.removeLastElementByListTest();
        test.removeElementByEmptyListTest();
        test.removeElementBySizeListIsOneTest();
    }

    void removeFirstElementByListTest() throws Exception {
        var list = LinkedListBuilder.build();
        list.remove(12);

        if (list.find(12) != null) {
            throw new Exception("Test removeFirstElementByListTest failed.");
        } else {
            System.out.println("removeFirstElementByListTest passed");
        }
    }

    void removeSecondElementByListTest() throws Exception {
        var list = LinkedListBuilder.build();
        list.remove(55);

        if (list.find(55) != null) {
            throw new Exception("Test removeSecondElementByListTest failed.");
        } else {
            System.out.println("removeSecondElementByListTest passed");
        }
    }

    void removeLastElementByListTest() throws Exception {
        var list = LinkedListBuilder.build();
        list.remove(128);

        if (list.find(128) != null) {
            throw new Exception("Test removeLastElementByListTest failed.");
        } else {
            System.out.println("removeLastElementByListTest passed");
        }
    }

    void removeElementByEmptyListTest() throws Exception {
        var list = new LinkedList();
        list.remove(128);

        if (list.find(128) != null) {
            throw new Exception("Test removeElementByEmptyListTest failed.");
        } else {
            System.out.println("removeElementByEmptyListTest passed");
        }
    }

    void removeElementBySizeListIsOneTest() throws Exception {
        var list = new LinkedList();
        list.addInTail(new Node(128));
        list.remove(128);

        if (list.head != null || list.tail != null) {
            throw new Exception("Test removeElementBySizeListIsOneTest failed.");
        } else {
            System.out.println("removeElementBySizeListIsOneTest passed");
        }
    }
}
