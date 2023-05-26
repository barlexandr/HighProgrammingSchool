package dynArray;

public class DynArrayInsertTest {

    public static void main(String[] args) throws Exception {
        var test = new DynArrayInsertTest();

//        test.insert_bufferSizeExceededTest();
//        test.insert_bufferSizeNotExceededTest();
//        test.insert_elementAtInvalidPosition();
        test.insert_bufferSizeExceeded_indexEqualsCountTest();
    }

    void insert_bufferSizeNotExceededTest() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
        array.insert(2, 5);

        if (array.capacity != 16 && array.getItem(5) != 2) {
            throw new Exception("Test insert_bufferSizeNotExceededTest failed.");
        }
    }

    void insert_bufferSizeExceededTest() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
        fillArray(array);
        array.insert(2, 5);
        array.insert(512, 25);

        if (array.capacity != 32 && array.getItem(5) != 2 && array.getItem(25) != 512) {
            throw new Exception("Test insert_bufferSizeExceededTest failed.");
        }
    }

    void insert_bufferSizeExceeded_indexEqualsCountTest() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
//        fillArray(array);
        array.insert(2, 16);

        if (array.capacity != 16 && array.getItem(15) != 2) {
            throw new Exception("Test insert_bufferSizeExceeded_indexEqualsCountTest failed.");
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
