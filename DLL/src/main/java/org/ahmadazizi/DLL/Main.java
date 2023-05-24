package org.ahmadazizi.DLL;

public class Main {
    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<Integer>();
        dll.addFirst(12);
        dll.addFirst(13);
        dll.addFirst(14);
        dll.addFirst(15);
        dll.addFirst(16);
        System.out.println(dll.toString());
        dll.reverse();
        System.out.println(dll.toString());
    }
}
