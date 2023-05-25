package main.java.org.ahmadazizi.CLL;

import java.util.ArrayList;

public class CircularLinkedList<T> {


	private Node<T> first = null;

	public T deleteFirst() {
		if(first == null) {
			System.out.println("Error >> CLL is Empty");
			return null;
		}else if(first.next == first) {
			T temp = first.data;
			first = null;
			return temp;
		}else {
			Node<T> node = first;
			T temp = first.data;
			while(node.next != first){
				node = node.next;
			}
			node.next = first.next;
			first = first.next;
			return temp;
		}
	}
	//ok-f

	public T deleteLast() {
		if(first == null) {
			System.out.println("Error >> CLL is Empty");
			return null;
		}else if(first.next == first) {
			T temp = first.data;
			first = null;
			return temp;
		}else {
			Node<T> temp = first;
			while(temp.next.next != first) {
				temp = temp.next;
			}
			T temp2 = temp.next.data;
			temp.next = first;
			return temp2;
		}
	}
	//ok-f

	public T deleteValue(T value) {
		T result = null;
		if(first == null){
			System.out.println("Error >> CLL is Empty");
			return null;
		}else if(first.next == first){
			if(first.data == value) {
				result = first.data;
				first = null;
				return result;
			}else{
				System.out.println("Not Found");
				return null;
			}
		}else{
			Node<T> node = first;
			if(first.data == value){
				result = first.data;
				deleteFirst();
				return result;
			}else {
				while (node.next != first){
					if(node.next.data.equals(value)){
						result = node.next.data;
						node.next = node.next.next;
						return result;
					}
					node = node.next;
				}
			}
			System.out.println("Not Found");
			return null;
		}
	}
	//ok-f

	public void reversePrint(Node<T> p){
		if(p.next != first) {
			reversePrint(p.next);
		}
		System.out.println(p.data);
	}
	//OK-f

	public void changeFirst(T input) {
		first.data = input;
	}

	//ok-f
	public void addAtFirst(T input) {
		if(first == null) {
			Node<T> node = new Node<T>();
			node.data = input;
			node.next = node;
			first = node;
		}else {
			Node<T> end = first;
			while(end.next != first) {
				end = end.next;
			}
			Node<T> node = new Node<T>();
			node.data = input;
			node.next = first;
			end.next = node;
			first = node;
		}
	}

	//ok-f
	public void addAtLast(T input) {
		if(first == null) {
			Node<T> node = new Node<T>();
			node.data = input;
			first = node;
			first.next = first;
		}else if(first.next == first) {
			Node<T> node = new Node<T>();
			node.data = input;
			node.next = first;
			first.next = node;
		} else{
			Node<T> temp = first;
			Node<T> node = new Node<T>();
			node.data = input;
			node.next = first;
			while(temp.next != first){
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	//Ok-f

	public void addAfter(T input , T value) {
		Node<T> node = search(input);
		if(node == null)
			System.out.println("Error >> This Node Does Not Exist");
		else {
			if(node.next == first) {
				addAtFirst(value);
			}else{
				Node<T> newNode = new Node<T>();
				newNode.data = value;
				newNode.next = node.next;
				node.next = newNode;
			}
		}
	}

	//ok-f
	public void print() {
		Node<T> node = first;
		do {
			System.out.println(node.data);
			node = node.next;
		}while(node != first);
	}

	//ok-f
	public void printFirst() {
		System.out.println(first.data);
	}
	//ok-f

	public Node<T> search(T input) {
		if (first == null) {
			System.out.println("Error >> CLL is Empty");
			return null;
		} else if (first.data.equals(input)) {
			return first;
		} else {
			Node<T> node = first.next;
			while (node != first) {
				if (node.data.equals(input)) {
					return node;
				}
				node = node.next;
			}
			System.out.println("Not Found");
			return null;
		}
	}
	//ok-f

	public boolean isEmpty(){
		return first == null;
	}
	//ok-f


	public boolean contains(T input){
		if (first == null) {
			return false;
		} else if (first.data.equals(input)) {
			return true;
		} else {
			Node<T> node = first.next;
			while (node != first) {
				if (node.data.equals(input)) {
					return true;
				}
				node = node.next;
			}
			return false;
		}
	}
//ok-f
public ArrayList<T> toArrayList(){
	ArrayList<T> arrayList = new ArrayList<T>();
	if(first == null)
		return null;
	else if(first.next == first) {
		arrayList.add(first.data);
		return arrayList;
	}else {
		Node<T> node = first;
		ArrayList<T> result = new ArrayList<T>();
		result.add(first.data);
		while(node.next != first){
			node = node.next;
			result.add(node.data);
		}
		return result;
	}
}
	//ok-f

	public void removeDuplicates() {
		if (first == null) return;
		Node<T> current = first;
		do {
			Node<T> runner = current;
			while (runner.next != first) {
				if (runner.next.data.equals(current.data)) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		} while (current != first);
	}
	//ok-f

	public void clear(){
		first = null;
	}
//ok-f
public Node<T> getFirst() {
	return first;
}
//ok-f
public Node<T> getLast(){
	Node<T> node = first;
	while (node.next != first){
		node = node.next;
	}
	return node;
}
//ok-f

	public void merge(CircularLinkedList<T> input){
		ArrayList<T> temp = input.toArrayList();
		for (T t : temp){
			addAtLast(t);
		}
	}
//ok-f

	public void reverse(){
		Node<T> node = first;
		CircularLinkedList<T> temp = new CircularLinkedList<>();
		while (node.next != first){
			temp.addAtFirst(node.data);
			node = node.next;
		}
		temp.addAtFirst(node.data);
		first = temp.getFirst();
	}
}