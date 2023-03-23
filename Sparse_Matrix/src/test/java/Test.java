import org.ahmadazizi.sparse.Sparse_Matrix;

import javax.naming.InsufficientResourcesException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        Sparse_Matrix<Integer> sparse = new Sparse_Matrix<Integer>(9,10);
        sparse.add(8,0,11);
        sparse.add(0,7,-3);
        sparse.add(5,3,8);
        sparse.add(5,2,4);
        sparse.add(2,6,13);
        sparse.add(4,0,5);
        sparse.add(2,3,9);
        sparse.add(0,8,2);
        System.out.println(sparse.toString() + "\n");
        sparse.transform();
        System.out.println(sparse.toString());
    }
}
