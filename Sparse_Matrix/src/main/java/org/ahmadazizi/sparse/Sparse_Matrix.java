package org.ahmadazizi.sparse;

import java.util.ArrayList;
import java.util.Arrays;

public class Sparse_Matrix<T>{
    private ArrayList<Sparse<T>> sparses = new ArrayList<Sparse<T>>();
    private int column;
    private int row;
    public Sparse_Matrix(int column, int row){
        this.column = column;
        this.row = row;
    }

    public void add(Sparse<T> sparse) {
        sparses.add(sparse);
        sort();
    }

    public void add(int column, int row , T value) {
        Sparse<T> sparse = new Sparse<T>();
        sparse.column = column;
        sparse.row = row;
        sparse.value = value;
        sparses.add(sparse);
    }

    public Object[][] getArray() {
        Object[][] array = new Object[row][column];
        for (int i = 0; i < sparses.size(); i++) {
            array[sparses.get(i).row][sparses.get(i).column] = sparses.get(i).value;
        }
        return array;
    }

    public T getValue(int row , int column) {
        for(int i = 0; i < sparses.size(); i++) {
            if(sparses.get(i).row == row) {
                while (true) {
                    if (sparses.get(i).column == column) {
                        return sparses.get(i).value;
                    } else {
                        i++;
                    }
                }
            }
        }
        return null;
    }

    public void transform(){
        for(int i = 0; i < sparses.size(); i++){
            int temp = sparses.get(i).row;
            sparses.get(i).row = sparses.get(i).column;
            sparses.get(i).column = temp;
        }
        int temp = row;
        row = column;
        column = temp;
        sort();
    }

    @Override
    public String toString(){
        String st = Arrays.deepToString(getArray());
        st = st.replaceAll("null" , "0");
        st = st.replaceAll("]," , "]\n");
        return st;
    }
    private void sort() {
        int len = sparses.size();
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (sparses.get(j).row > sparses.get(j + 1).row) {
                    Sparse<T> temp = sparses.get(j);
                    sparses.set(j, sparses.get(j + 1));
                    sparses.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < len - 1; i++) {
            if (sparses.get(i).row == sparses.get(i + 1).row) {
                if (sparses.get(i).column > sparses.get(i + 1).column) {
                    Sparse<T> temp = sparses.get(i);
                    sparses.set(i, sparses.get(i + 1));
                    sparses.set(i + 1, temp);
                }
                if (sparses.get(i).column < sparses.get(i + 1).column) {
                    Sparse<T> temp = sparses.get(i + 1);
                    sparses.set(i + 1, sparses.get(i));
                    sparses.set(i, temp);
                }
            }
        }
    }


}