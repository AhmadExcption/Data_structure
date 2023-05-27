import java.util.concurrent.BlockingDeque;

public class Main {

	public static void main(String[] args) {
		Generic_Tree<Integer> gt = new Generic_Tree<Integer>(0);
		gt.add_Child(0, 1);
		gt.add_Child(0, 2);
		gt.add_Child(0, 3);
		gt.add_Child(1, 6);
		gt.add_Child(1, 7);
		gt.add_Child(1, 8);
		gt.add_Child(2, 9);
		gt.add_Child(2, 10);
		gt.add_Child(3, 11);
		gt.add_Child(3, 12);
		gt.add_Child(3, 13);

		Generic_Tree<Integer> gt2 = new Generic_Tree<Integer>(1);
		gt2.add_Child(1, 6);
		gt2.add_Child(1, 7);
		gt2.add_Child(1, 8);
		System.out.println(gt2.toString());

		System.out.println(gt.toString());

		System.out.println(gt.isSubtree(gt2));
	}

}
