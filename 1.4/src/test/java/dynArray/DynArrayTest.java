package dynArray;

class DynArrayTest {

    public static void main(String[] args) {
        var test = new DynArrayTest();
//        test.makeArray_test();
//        test.getItem_test();
//        test.insert_test();
        test.insert_fullArrayTest();
    }

    void makeArray_test() {
        var array = new DynArray<Integer>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(1);
        array.append(4);
        array.append(5);
    }

    void getItem_test() {
        var array = new DynArray<Integer>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(1);
        array.append(4);
        array.append(5);
        var a = array.getItem(6);

    }

    void insert_test() {
        var array = new DynArray<Integer>(Integer.class);
        array.append(1);

        array.insert(100, 0);

    }

    void insert_fullArrayTest() {
        var array = new DynArray<Integer>(Integer.class);
        array.append(11);
//        array.append(12);
//        array.append(13);
//        array.append(14);
//        array.append(15);
//        array.append(16);
//        array.append(17);
//        array.append(18);
//        array.append(19);
//        array.append(20);
//        array.append(21);
//        array.append(22);
//        array.append(23);
//        array.append(24);
//        array.append(25);

        array.insert(100, 16);

    }

}