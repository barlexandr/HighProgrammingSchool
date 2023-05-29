package dynArray;

class DynArrayTest {

    public static void main(String[] args) throws Exception {
        var test = new DynArrayTest();

        test.getItem_test();
        test.appendAnyTypeElementTest();
    }

    void getItem_test() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(1);
        array.append(4);
        array.append(5);
        var result = array.getItem(6);

        if (result != null) {
            throw new Exception("Test getItem_test failed.");
        }

    }

    void appendAnyTypeElementTest() throws Exception {
        var array = new DynArray<>(Integer.class);
        boolean testPassed = false;
        array.insert(1, 0);
        try {
            array.append(1.0);
        } catch (Exception e) {
            testPassed = true;
        }
        if (!testPassed) {
            throw new Exception("Test appendAnyTypeElementTest failed.");
        }
    }

}