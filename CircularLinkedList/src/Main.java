import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
        cll.addAtLast(3);
        cll.addAtLast(4);
        cll.addAtLast(5);
        cll.addAtLast(6);
        cll.addAtLast(7);
        cll.addAtLast(8);
        cll.addAtLast(9);
        cll.print();
        cll.reverse();
        System.out.println("//////////////////////////////////////////");
        cll.print();
    }

}
