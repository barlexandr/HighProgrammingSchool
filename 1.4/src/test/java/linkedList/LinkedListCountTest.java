package linkedList;

public class LinkedListCountTest {

    public static void main(String[] args) throws Exception {
        var test = new LinkedListCountTest();
        test.count_threeSize_Test();
        test.count_zeroSize_Test();
        test.count_oneSize_Test();
    }

    void count_threeSize_Test() throws Exception {
        var list = LinkedListBuilder.build();
        var size = list.count();

        if (size != 3) {
            throw new Exception("Test count_threeSize_Test failed.");
        } else {
            System.out.println("count_threeSize_Test passed");
        }
    }

    void count_zeroSize_Test() throws Exception {
        var list = new LinkedList();
        var size = list.count();

        if (size != 0) {
            throw new Exception("Test count_zeroSize_Test failed.");
        } else {
            System.out.println("count_zeroSize_Test passed");
        }
    }

    void count_oneSize_Test() throws Exception {
        var list = new LinkedList();
        list.addInTail(new Node(0));
        var size = list.count();

        if (size != 1) {
            throw new Exception("Test count_zeroSize_Test failed.");
        } else {
            System.out.println("count_oneSize_Test passed");
        }
    }
}
