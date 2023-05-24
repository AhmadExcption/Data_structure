package org.ahmadazizi.SLL;


import java.util.ArrayList;

public class SinglyLinkedList<T> {
	private Node<T> first = null;

	public T getFirst(){
		return first.element;
}

	public T getLast(){
		if(first == null){
			System.out.println("Error >> SLL is Empty");
			return null;
		}else if(first.next == null){
			return first.element;
		}else{
			Node<T> node = first;
			while (node.next == null){
				node = node.next;
			}
			return node.element;
		}
	}

	public T getIndex(int index){
		if(first == null){
			System.out.println("Error >> SLL is Empty");
			return null;
		}else if(index < 0){
			System.out.println("Error >> Index is not invalid");
			return null;
		}else if(index >= size()){
			System.out.println("Error >> Index is not invalid");
			return null;
		}else {
			Node<T> node = first;
			for(int i = 0; i < index ; i++){
				node = node.next;
			}
			return node.element;
		}
	}

	public T deleteFirst() {
		if (first == null) {
			System.out.println("Error >> SLL is Empty");
			return null;
		} else if (first.next == null) {
			T temp = first.element;
			first = null;
			return temp;
		} else {
			T temp = first.element;
			first = first.next;
			return temp;
		}
	}
//ok-f
	public T deleteLast() {
		if (first == null) {
			System.out.println("Error >> SLL is Empty");
			return null;
		} else if (first.next == null) {
			T temp = first.element;
			first = null;
			return temp;
		} else {
			Node<T> temp = first;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			T result = temp.next.element;
			temp.next = null;
			return result;
		}
	}
	//ok-f
	public T delete(T value) {
		if (first == null) {
			System.out.println("Error >> SLL is Empty");
		} else if (first.next == null) {
			if (first.element == value) {
				T temp = first.element;
				first = null;
				return temp;
			} else {
				System.out.println("Error >> Not Found");
			}
		} else {
			if (first.element == value)
				return deleteFirst();
			else {
				if (first.element == value) {
					return deleteFirst();
				} else {
					Node<T> temp = first;
					while (temp != null) {
						if (temp.next.element.equals(value)) {
							break;
						}
						temp = temp.next;
					}
					if (temp.next.element.equals(value)) {
						T temp2 = temp.next.element;
						temp.next = temp.next.next;
						return temp2;
					}
				}
			}
		}
		return null;
	}
	//ok-f
	public void reversePrint(Node<T> p){
		if(p.next != null) {
			reversePrint(p.next);
		}
		System.out.println(p.element);
	}
	//ok-f
	public Node<T> reverseSSL(Node<T> p) {
		if(p.next.next == null) {
			first = p.next;
		} else {
			first = reverseSSL(p.next);
		}
		p.next.next = p;
		p.next = null;
		return first;
	}
	//ok-f
	public void addAtFirst(T input) {
		Node<T> node = new Node<T>();
		node.element = input;
		node.next = first;
		first = node;
	}
	//ok-f
	public void addAtLast(T input) {
		if (first == null) {
			addAtFirst(input);
		} else {
			Node<T> node = new Node<T>();
			node.element = input;
			node.next = null;
			Node<T> temp = first;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	//ok-f
	public void add(T input , int index) {
		if(index < 0) {
			System.out.println("Error >> Invalid index ");
		}else if(index == 0)
			addAtFirst(input);
		else {
			if(index <= size()) {
				Node<T> node = new Node<T>();
				node.element = input;
				Node<T> temp = first;
				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}
				node.next = temp.next;
				temp.next = node;
			}
		}
	}
		//ok-f

	public int size() {
		if(first == null)return 0;
		Node<T> temp = first;
		int ans = 0;
		while(temp != null) {
			temp = temp.next;
			ans += 1;
		}
		return ans;
	}

	//ok-f
	public void print() {
		Node<T> node = first;
		while(node != null) {
			System.out.println(node.element);
			node = node.next;
		}
	}
	//ok-f


	public boolean contains(T value) {
		if(first == null){
			return false;
		}else if(first.next == null){
			if(first.element.equals(value)){
				return true;
			}else{
				return false;
			}
		}else{
			Node<T> node = first;
			while(node != null){
				if(node.element.equals(value)){
					return true;
				}else{
					node = node.next;
				}
			}
			return false;
		}
	}

	public ArrayList<T> toArrayList(){
		if(first == null){
			return new ArrayList<T>();
		}else{
			ArrayList<T> list = new ArrayList<T>();
			Node<T> node = first;
			while(node != null){
				list.add(node.element);
				node = node.next;
			}
			return list;
		}
	}


	public void clear(){
		first = null;
	}

}

