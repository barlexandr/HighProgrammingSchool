package dynArray;

public class DynArrayInsertTest {

    public static void main(String[] args) throws Exception {
        var test = new DynArrayInsertTest();

        test.insert_bufferSizeExceededTest();
        test.insert_bufferSizeNotExceededTest();
        test.insert_elementAtInvalidPosition();
        test.insertAnyTypeElementTest();
    }

    void insert_bufferSizeNotExceededTest() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
        array.insert(2, 0);

        if (array.capacity != 16 || array.getItem(5) != null) {
            throw new Exception("Test insert_bufferSizeNotExceededTest failed.");
        }
    }

    void insert_bufferSizeExceededTest() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
        boolean passed = false;
        fillArray(array);
        array.insert(2, 5);
        try {
            array.insert(512, 25);
        } catch (Exception e) {
            if (e instanceof IndexOutOfBoundsException) {
                passed = true;
            }
        }

        if (array.capacity != 32 || array.getItem(5) != 2 || !passed) {
            throw new Exception("Test insert_bufferSizeExceededTest failed.");
        }
    }

    void insert_elementAtInvalidPosition() throws Exception {
        var array = new DynArray<Integer>(Integer.class);

        try {
            array.insert(1, 17);
        } catch (Exception e) {
            if (e.getClass() != IndexOutOfBoundsException.class) {
                throw new Exception("Test insert_elementAtInvalidPosition failed.");
            }
        }
    }

    void insertAnyTypeElementTest() throws Exception {
        var array = new DynArray<>(Integer.class);
        boolean testPassed = false;
        array.insert(1, 0);
        try {
            array.insert(1.0, 1);
        } catch (Exception e) {
            testPassed = true;
        }
        if (!testPassed) {
            throw new Exception("Test insertAnyTypeElementTest failed.");
        }
    }

    void fillArray(DynArray array) {
        array.append(1);
        array.append(2);
        array.append(3);
        array.append(4);
        array.append(5);
        array.append(6);
        array.append(7);
        array.append(8);
        array.append(9);
        array.append(10);
        array.append(11);
        array.append(12);
        array.append(13);
        array.append(14);
        array.append(15);
        array.append(16);
        array.append(17);
        array.append(18);
    }
}
