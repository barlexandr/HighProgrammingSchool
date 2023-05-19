package task1;

public class LinkedListClearTest {

    public static void main(String[] args) throws Exception {
        var test = new LinkedListClearTest();
        test.clearTest();
    }

    void clearTest() throws Exception {
        var list = LinkedListBuilder.build();
        list.clear();

        if (list.head != null && list.tail != null) {
            throw new Exception("Test clearTest failed.");
        } else {
            System.out.println("clearTest passed");
        }
    }
}
