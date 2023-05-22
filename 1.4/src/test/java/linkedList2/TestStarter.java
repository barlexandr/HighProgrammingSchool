package linkedList2;

public class TestStarter {

    public static void main(String[] args) throws Exception {
        var clearTest = new LinkedList2ClearTest();
        var findAllTest = new LinkedList2FindAllTest();
        var findTest = new LinkedList2FindTest();
        var insertAfterTest = new LinkedList2InsertAfterTest();
        var removeAllTest = new LinkedList2RemoveAllTest();
        var removeTest = new LinkedList2RemoveTest();

        clearTest.clear_ByListEmptyTest();
        clearTest.clear_ByListHasOneElementTest();
        clearTest.clear_ByListHasAnyElementsTest();

        findAllTest.findAll_ByListEmptyTest();
        findAllTest.findAll_ByListHasOneElementTest();
        findAllTest.findAll_ByListHasTwoElementTest();
        findAllTest.findAll_ByListHasTwoEqualsElementTest();
        findAllTest.findAll_ByListHasThreeElementTest();
        findAllTest.findAll_ByListHasThreeEqualsElementTest();

        findTest.find_ByListEmptyTest();
        findTest.find_ByListHasOneElementTest();
        findTest.find_ByListHasTwoElementTest();
        findTest.find_ByListHasThreeElementTest();
        findTest.find_ByListHasFourElementTest();
        findTest.find_ByListHasFiveElementTest();

        insertAfterTest.insertAfter_ByListEmptyTest();
        insertAfterTest.insertAfter_ByFirstElementTest();
        insertAfterTest.insertAfter_ByListHasOneElementTest();
        insertAfterTest.insertAfter_ByListHasTwoElementTest_addInMiddle();

        removeAllTest.removeAll_ByListEmptyTest();
        removeAllTest.removeAll_ByListHasOneElementTest();
        removeAllTest.removeAll_ByListHasTwoElementTest();
        removeAllTest.removeAll_ByListHasThreeElementTest();
        removeAllTest.removeAll_ByListHasThreeElementTest_removeTwoElement();
        removeAllTest.removeAll_ByListHasThreeElementTest_removeAllElement();

        removeTest.remove_ByListEmptyTest();
        removeTest.remove_ByListHasOneElementTest();
        removeTest.remove_ByListHasTwoElementTest_deletedHead();
        removeTest.remove_ByListHasTwoElementTest_deletedTail();
        removeTest.remove_ByListHasThreeElementTest_deletedHead();
        removeTest.remove_ByListHasThreeElementTest_deletedTail();
        removeTest.remove_ByListHasThreeElementTest_deletedMiddle();

    }
}
