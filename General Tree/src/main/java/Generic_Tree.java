
public class Generic_Tree<T> {
	private Node<T> root = new Node<T>() ;

	public Generic_Tree (T dataRoot){
		root.data = dataRoot;
		root.level = 1;
		root.parent = null;
	}

	public Generic_Tree(Node<T> root) {
		this.root = root;
	}

	public void setDataRoot(T data) {
		root.data = data;
		root.level = 1;
		root.parent = null;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public T getDataRoot() {
		return root.data;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void add_Child(Node<T> parent , T data) {
		Node<T> node = new Node<T>();
		node.parent = parent;
		node.data = data;
		node.level = parent.level + 1;
		parent.childrens.add(node);
	}

	public void add_Child(T parent , T data) {
		Node<T> node1 = search(parent);
		Node<T> node2 = new Node<T>();
		node2.data = data;
		node2.level = node1.level + 1;
		node2.parent = node1;
		node1.childrens.add(node2);
	}

	public void addTree(T parent , Generic_Tree<T> tree) {
		Node<T> node0 = search(parent);
		Node<T> node1 = tree.getRoot();
		increaseLVL(node0.level, node1);
		node1.parent = node0;
		node0.childrens.add(node1);
	}

	public void increaseLVL(int value , Node<T> input){
		input.level = input.level + value +1;
		for(int i = 0 ; i < input.childrens.size() ; i++) {
			increaseLVL(value, input.childrens.get(i));
		}
	}

	public void addTree(Node<T> parent , Generic_Tree<T> tree) {
		increaseLVL(parent.level, tree.root);
		parent.childrens.add(tree.getRoot());
	}

	public void delete(T parent ,T target) {
		Node<T> node = search(target);
		Node<T> temp = node.parent;
		if(temp.data.equals(parent))
			temp.childrens.remove(node);
	}

	public void delete(Node<T> target) {
		Node<T> parent = target.parent;
		parent.childrens.remove(target);
	}

	public void removeAll(T root) {
		this.root.childrens.removeAll(this.root.childrens);
		this.root.data = root;
	}

	public Node<T> search(T data){
		return h_search(data , root);
	}

	private Node<T> h_search(T data , Node<T> node){
		if(node.data.equals(data))
			return node;
		for(int i = 0 ; i < node.childrens.size() ; i++) {
			if(node.childrens.get(i).data.equals(data)) {
				return node.childrens.get(i);
			}
		}
		Node<T> _node = root;
		for(int i = 0 ; i < node.childrens.size() ; i++) {
			_node = h_search(data, node.childrens.get(i));
			if(_node != null && _node.data.equals(data))
				return _node;
		}
		return null;
	}

	public int LeafNumberLVL(int level) {
		return h_LeafNumberLVL(root, level);
	}

	private int h_LeafNumberLVL(Node<T> input , int level) {
		if(input.level == level)
			return 1;
		else {
			int temp = 0;
			for(int i = 0 ; i < input.childrens.size() ; i++) {
				temp = temp + h_LeafNumberLVL(input.childrens.get(i), level);
			}
			return temp;
		}
	}

	public void circularRight() {
		Node<T> temp = root.childrens.get(root.childrens.size() - 1);
		root.childrens.remove(root.childrens.size() - 1);
		increaseLVL(-2, temp);
		temp.parent = null;
		increaseLVL(1, root);
		root.parent = temp;
		temp.childrens.add(root);
		root = temp;
	}

	public void circularLeft() {
		Node<T> temp = new Node<T>();
		temp = root.childrens.get(0);
		root.childrens.remove(0);
		increaseLVL(-root.level -1, temp);
		temp.parent = null;
		increaseLVL(1, root);
		root.parent = temp;
		temp.childrens.add(root);
		root = temp;
	}

	public void eraAroundRoot() {
		for(int i = 0 ; i < root.childrens.size() ; i++) {
			Node<T> node = root.childrens.get(i);
			root.childrens.set(i,root.childrens.get(root.childrens.size() - 1 -i));
			root.childrens.set(root.childrens.size() - 1 -i, node);
		}
	}


	public boolean isBinary() {
		return h_isBinary(root);
	}

	private boolean h_isBinary(Node<T> node) {
		if(node.childrens.size() > 2)
			return false;
		if(node.childrens.size() == 0)
			return true;
		for(int i = 0 ; i < node.childrens.size() ; i++) {
			if(h_isBinary(node.childrens.get(i)) == false) {
				return false;
			}
		}
		return true;
	}


	public boolean isExist(T input){
		return h1_isExist(input, root);
	}

	private boolean h1_isExist(T input , Node<T> temp) {
		if(temp.data == input)
			return true;
		else
			for(int i = 0 ; i < temp.childrens.size() ; i++) {
				if (h1_isExist(input, temp.childrens.get(i))) {
					return true;
				}
			}
		return false;
	}

	public boolean isExist(Node<T> node) {
		return h2_isExist(node, root);
	}

	private boolean h2_isExist(Node<T> input , Node<T> temp) {
		if(temp == input)
			return true;
		else
			for(int i = 0 ; i < temp.childrens.size() ; i++) {
				if (h2_isExist(input, temp.childrens.get(i))) {
					return true;
				}
			}
		return false;
	}

	public boolean isEmpty() {
		return root.equals(null);
	}

	public int size() {
		return h_size(root);
	}
	private int h_size(Node<T> node) {
		if(node.childrens.size() == 0){
			return 1;
		}else{
			int size = 1;
			for(int i = 0; i < node.childrens.size(); i++){
				size += h_size(node.childrens.get(i));
			}
			return size;
		}
	}

	public boolean isSubtree(Generic_Tree<T> tree){return h_isSubtree(root , tree.root);}

	private boolean h_isSubtree(Node<T> input , Node<T> node){
		if(input.data.equals(node.data)) {
			boolean result = true;
			for (int i = 0; i < node.childrens.size(); i++) {
				result = result && h_isSubtree(input.childrens.get(i), node.childrens.get(i));
			}
			if(result == true) {
				return true;
			}
		}
		boolean result = false;
		for(int i = 0; i < input.childrens.size(); i++){
			result = result || h_isSubtree(input.childrens.get(i),node);
		}
		return result;
	}
	public void traversePreOrder(CodeBlock code){
		h_traversePreOrder(root , code);
	}

	private void h_traversePreOrder(Node<T> node , CodeBlock code){
		if(node == null) return;
		code.execute((Node<Object>) node);
		for(int i = 0 ; i < node.childrens.size() ; i++){
			h_traversePreOrder(node.childrens.get(i), code);
		}
	}


	public void traversePostOrder(CodeBlock code){h_traversePostOrder(root, code);}

	private void h_traversePostOrder(Node<T> node , CodeBlock code){
		if(node == null) return;
		for(int i = 0 ; i < node.childrens.size() ; i++){
			h_traversePostOrder(node.childrens.get(i), code);
		}
		code.execute((Node<Object>) node);
	}

	public String toString() {
		return h_toString(root);
	}

	private String h_toString(Node<T> temp){
		String st = "";
		for(int i = 1 ; i < temp.level ; i++)
			st = st + "  ";
		if(temp.parent != null)
			st = st +"|--" +(T) temp.data + "\n";
		else
			st = st + (T) temp.data + "\n";
		for(int i = 0; i < temp.childrens.size() ; i++) {
			st = st + h_toString(temp.childrens.get(i));
		}
		return st;
	}

}