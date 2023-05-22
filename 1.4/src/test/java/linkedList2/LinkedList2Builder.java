package linkedList2;

public class LinkedList2Builder {

    public static LinkedList2 build() {
        var s_list = new LinkedList2();
        var n1 = new Node(12);
        var n2 = new Node(55);
        var n3 = new Node(128);
        s_list.addInTail(n1);
        s_list.addInTail(n2);
        s_list.addInTail(n3);
        return s_list;
    }
}
