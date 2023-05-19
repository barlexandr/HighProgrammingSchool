package task1;

import java.io.IOException;

class PointEightTest {

    public static void main(String[] args) throws Exception {
        PointEightTest test = new PointEightTest();
        test.addTwoLinkedListByValueItem_threeElementTest();
        test.addTwoLinkedListByValueItem_oneElementTest();
        test.addTwoLinkedListByValueItem_listEmptyTest();
        test.addTwoLinkedListByValueItem_notEqualsSizeTest();
    }

    void addTwoLinkedListByValueItem_threeElementTest() throws Exception {
        var listOne = new LinkedList();
        var listTwo = new LinkedList();
        listOne.addInTail(new Node(0));
        listOne.addInTail(new Node(32));
        listOne.addInTail(new Node(5));

        listTwo.addInTail(new Node(100));
        listTwo.addInTail(new Node(20));
        listTwo.addInTail(new Node(43));

        var result = PointEight.getTheSumOfCorrespondingElementsOfLinkedListOfEqualLength(listOne, listTwo);

        if (result.count() != 3 && result.head.value != 100 && result.head.next.value != 52
                && result.head.next.next.value != 48 && result.tail.value != 48) {
            throw new Exception("Test addTwoLinkedListByValueItem_threeElementTest failed.");
        } else {
            System.out.println("addTwoLinkedListByValueItem_threeElementTest passed");
        }
    }

    void addTwoLinkedListByValueItem_oneElementTest() throws Exception {
        var listOne = new LinkedList();
        var listTwo = new LinkedList();
        listOne.addInTail(new Node(0));
        listTwo.addInTail(new Node(100));

        var result = PointEight.getTheSumOfCorrespondingElementsOfLinkedListOfEqualLength(listOne, listTwo);

        if (result.count() != 1 && result.head.value != 100) {
            throw new Exception("Test addTwoLinkedListByValueItem_oneElementTest failed.");
        } else {
            System.out.println("addTwoLinkedListByValueItem_oneElementTest passed");
        }
    }

    void addTwoLinkedListByValueItem_listEmptyTest() throws Exception {
        var listOne = new LinkedList();
        var listTwo = new LinkedList();

        var result = PointEight.getTheSumOfCorrespondingElementsOfLinkedListOfEqualLength(listOne, listTwo);

        if (result.head != null && result.tail != null) {
            throw new Exception("Test addTwoLinkedListByValueItem_listEmptyTest failed.");
        } else {
            System.out.println("addTwoLinkedListByValueItem_listEmptyTest passed");
        }
    }

    void addTwoLinkedListByValueItem_notEqualsSizeTest() throws Exception {
        var listOne = new LinkedList();
        var listTwo = new LinkedList();
        listOne.addInTail(new Node(1));

        Exception exception = new Exception();
        try {
            PointEight.getTheSumOfCorrespondingElementsOfLinkedListOfEqualLength(listOne, listTwo);
        } catch (IOException ex) {
            exception = ex;
        }
        if (exception.getClass() != IOException.class) {
            throw new Exception("Test addTwoLinkedListByValueItem_notEqualsSizeTest failed.");
        } else {
            System.out.println("addTwoLinkedListByValueItem_notEqualsSizeTest passed");
        }
    }
}