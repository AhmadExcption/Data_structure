import org.ahmadazizi.array.MyArray;

public class Test {
    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<Integer>(10,-4);
        array.store(-4,10);
        array.store(-3,9);
        array.store(-2,8);
        array.store(-1,7);
        array.store(0,6);
        array.store(1,5);
        array.store(2,4);
        array.store(3,3);
        array.store(4,2);
        array.store(5,1 );
        System.out.println(array.retrieve(-4));
        System.out.println(array.retrieve(-3));
        System.out.println(array.retrieve(-2));
        System.out.println(array.retrieve(-1));
        System.out.println(array.retrieve(0));
        System.out.println(array.retrieve(1));
        System.out.println(array.retrieve(2));
        System.out.println(array.retrieve(3));
        System.out.println(array.retrieve(4));
        System.out.println(array.retrieve(5));

    }
}
