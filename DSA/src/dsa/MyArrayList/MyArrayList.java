package dsa.MyArrayList;

public class MyArrayList {
    private int size = 0;
    private int capacity = 16;
    private String[] elements = new String[capacity];

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(String element) {
        elements[size++] = element;
    }

    public String get(int index) {
        return elements[index];
    }
}
