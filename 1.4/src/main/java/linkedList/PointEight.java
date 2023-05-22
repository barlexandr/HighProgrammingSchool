package linkedList;

import java.io.IOException;

public class PointEight {

    /**
     * Method return list, each element of which is equal to the sum of the corresponding elements of the input lists if their lengths are equal.
     * If the lengths of the lists are not equal, the method returns null.
     *
     * @param listOne First list.
     * @param listTwo Second list.
     * @return List whose each element is equal to the sum of the corresponding elements of the input lists or null.
     */
    public static LinkedList getTheSumOfCorrespondingElementsOfLinkedListOfEqualLength(LinkedList listOne, LinkedList listTwo) throws IOException {
        LinkedList resultList = new LinkedList();
        if (listOne.count() == listTwo.count()) {
            Node elementByListOne = listOne.head;
            Node elementByListTwo = listTwo.head;
            while (elementByListOne != null) {
                Node temp = new Node(elementByListOne.value + elementByListTwo.value);
                resultList.addInTail(temp);
                elementByListOne = elementByListOne.next;
                elementByListTwo = elementByListTwo.next;
            }
        } else {
            throw new IOException("You entered LinkedList of different lengths.\nPlease enter LinkedList of the same length.");
        }
        return resultList;
    }


}
