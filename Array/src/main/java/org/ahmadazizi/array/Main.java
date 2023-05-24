package org.ahmadazizi.array;

public class Main {
    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<Integer>(10,1);
        array.store(1,1);
        array.store(2,2);
        array.store(3,3);
        array.store(4,4);
        array.store(5,5);
        array.store(6,6);
        array.store(7,7);
        array.store(8,8);
        array.store(9,9);
        array.store(10,10);
        System.out.println(array.toString());
    }
}
