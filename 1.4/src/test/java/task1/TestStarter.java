package task1;

public class TestStarter {

    public static void main(String[] args) throws Exception {
        var listClearTest = new LinkedListClearTest();
        var listCountTest = new LinkedListCountTest();
        var insertAfterTest = new LinkedListInsertAfterTest();
        var removeAllTest = new LinkedListRemoveAllTest();
        var removeTest = new LinkedListRemoveTest();
        var pointEightTest = new PointEightTest();

        listClearTest.clearTest();

        listCountTest.count_oneSize_Test();
        listCountTest.count_zeroSize_Test();
        listCountTest.count_threeSize_Test();

        insertAfterTest.insertAfter_IfListHaveTwoElementTest();
        insertAfterTest.insertAfter_IfListSizeIsOneTest();
        insertAfterTest.insertAfter_IfListEmptyTest();

        removeAllTest.removeAll_IfListEmptyTest();
        removeAllTest.removeAll_IfListSizeIsOneTest();
        removeAllTest.removeAll_IfListHaveTwoElementAtValueTest();
        removeAllTest.removeAll_IfListHaveTwoElementAtThisValueTest();

        removeTest.removeLastElementByListTest();
        removeTest.removeElementByEmptyListTest();
        removeTest.removeFirstElementByListTest();
        removeTest.removeSecondElementByListTest();
        removeTest.removeElementBySizeListIsOneTest();

        pointEightTest.addTwoLinkedListByValueItem_notEqualsSizeTest();
        pointEightTest.addTwoLinkedListByValueItem_listEmptyTest();
        pointEightTest.addTwoLinkedListByValueItem_oneElementTest();
        pointEightTest.addTwoLinkedListByValueItem_threeElementTest();
    }
}
