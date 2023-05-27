
import java.util.ArrayList;

public class Node<T> {
	T data = null;
	ArrayList<Node<T>> childrens = new ArrayList<Node<T>>();
	Node<T> parent = null;
	int level = 0;
	
}
