package org.ahmadazizi.array;

public class MyArray<T> {
    private Object[] array;
    private int capacity;
    private int base;

    public MyArray(int capacity , int base) {
        this.base = base;
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void store(int index, T value) {
        if((index < base+capacity) && index >= base) {
            array[index - base] = value;
        }else{
            throw new RuntimeException("Invalid index");
        }
    }

    public Object retrieve(int index){
        if((index < base+capacity) && index >= base) {
            return array[index - base];
        }else{
            throw new RuntimeException("Invalid index");
        }
    }
}