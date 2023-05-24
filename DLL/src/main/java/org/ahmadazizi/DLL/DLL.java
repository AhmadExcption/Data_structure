package org.ahmadazizi.DLL;

import java.util.ArrayList;

public class DLL<T> {
    private Node<T> first = null;

    public void addFirst(T data) {
        Node node = new Node();
        node.data = data;
        if(first == null){
            first = node;
        }else{
            node.next = first;
            first.previous = node;
            first = node;
        }
    }

    public void addLast(T data) {
        Node node = new Node();
        node.data = data;
        if(first == null) {
            first = node;
        }else{
            Node<T> temp = first;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.previous = temp;
        }
    }

    public void add(int index ,T value) {
        if(index < 0){
            System.out.println("Error >> Index is not invalid");
        }else if(index == 0){
            addFirst(value);
        }else {
            Node<T> node = new Node<T>();
            node.data = value;
            Node<T> temp = first;
            for(int i = 0 ; i < index - 1 ; i++) {
                temp = temp.next;
            }
            node.previous = temp;
            node.next = temp.next;
            temp.next.previous = node;
            temp.next = node;
        }
    }

    public T removeFirst(){
        if(first == null){
            System.out.println("Error >> DLL is Empty");
            return null;
        }else if(first.next == null){
            T temp = first.data;
            first = null;
            return temp;
        }else {
            T temp = first.data;
            first.next.previous = null;
            first = first.next;
            return temp;
        }
    }

    public T removeLast(){
        if(first == null){
            System.out.println("Error >> DLL is Empty");
        }else if(first.next == null){
            T temp = first.data;
            first = null;
            return temp;
        }else {
            Node<T> temp = first;
            while(temp.next.next != null){
                temp = temp.next;
            }
            T result = temp.next.data;
            temp.next = null;
            return result;
        }
        return null;
    }
    public T remove(int index){
        if(index < 0){
            System.out.println("Error >> Index is not invalid");
            return null;
        }else if(index == 0){
            return removeFirst();
        } else if (index == (size()-1)) {
            return removeLast();
        } else {
            Node<T> temp = first;
            for(int i = 0 ; i < index  ; i++){
                temp = temp.next;
            }
            T result = temp.data;
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            return result;
        }
    }
    public int size(){
        Node<T> node = first;
        int size = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }

    public T getFirst(){
        return first.data;
    }

    public T getLast(){
        if(first == null){
            System.out.println("Error >> DLL is Empty");
            return null;
        }else if(first.next == null){
            return first.data;
        }else{
            Node<T> node = first;
            while(node.next != null){
                node = node.next;
            }
            return node.data;
        }
    }

    public T getIndex(int index) {
        if(index < 0){
            System.out.println("Error >> index is not invalid");
            return null;
        }else if (index >= size()){
            System.out.println("Error >> index is not invalid");
            return null;
        }else{
            if(first == null){
                System.out.println("Error >> DLL is Empty");
                return null;
            }else{
                Node<T> node = first;
                for(int i = 0; i < index; i++){
                    node = node.next;
                }
                return node.data;
            }
        }
    }

    public void reverse(){
        ArrayList<T> list = toArrayList();
        first = null;
        for(int i = 0; i < list.size(); i++){
            addFirst(list.get(i));
        }
    }
    public ArrayList<T> toArrayList(){
        if(first == null){
            return new ArrayList<T>();
        }else{
            Node<T> node = first;
            ArrayList<T> result = new ArrayList<T>();
            while(node != null){
                result.add(node.data);
                node = node.next;
            }
            return result;
        }
    }
    public String toString() {
        String result = "[";
        Node<T> temp = first;
        while(temp != null) {
            if(temp.next != null)
                result = result + temp.data.toString() +" ,";
            else
                result = result + temp.data.toString();
            temp = temp.next;
        }
        result = result +"]";
        return result;
    }
}
