package dynArray;

public class DynArrayRemoveTest {

    public static void main(String[] args) throws Exception {
        var test = new DynArrayRemoveTest();

        test.remove_bufferSizeNotExceededTest();
        test.remove_bufferSizeExceededTest();
        test.remove_elementAtInvalidPosition();
        test.remove_elementAtNullPosition();
    }

    void remove_bufferSizeNotExceededTest() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        array.append(4);
        array.remove(2);

        if (array.capacity != 16 || array.getItem(2) == null) {
            throw new Exception("Test remove_bufferSizeNotExceededTest failed.");
        }
    }

    void remove_bufferSizeExceededTest() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
        fillArray(array);
        array.remove(5);
        array.remove(6);
        array.remove(12);

        if (array.capacity != 21 || array.getItem(5) != 7 || array.getItem(20) != null) {
            throw new Exception("Test remove_bufferSizeExceededTest failed.");
        }

    }

    void remove_elementAtInvalidPosition() throws Exception {
        var array = new DynArray<Integer>(Integer.class);

        try {
            array.remove(17);
        } catch (Exception e) {
            if (e.getClass() != IndexOutOfBoundsException.class) {
                throw new Exception("Test remove_elementAtInvalidPosition failed.");
            }
        }
    }

    void remove_elementAtNullPosition() throws Exception {
        var array = new DynArray<Integer>(Integer.class);
        fillArray(array);
        array.remove(0);
        var item = array.getItem(0);

        if (item != 2) {
            throw new Exception("Test remove_elementAtNullPosition failed.");
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
