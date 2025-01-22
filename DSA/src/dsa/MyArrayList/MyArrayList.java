package dsa.MyArrayList;

public class MyArrayList {
    private int size = 0;
    private int capacity = 3;
    private String[] elements = new String[capacity];

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(String element) {
        elements[size++] = element;
        if (isFull()) increaseCapacity();
    }

    private void increaseCapacity() {
        capacity *= 2;
        String[] newElements = new String[capacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    private boolean isFull() {
        return size == capacity;
    }

    public String get(int index) throws Exception {
        if (isValidIndex(index))
            throw new IndexOutOfBoundsException("Index out of list bounds");
        return elements[index];
    }

    private boolean isValidIndex(int index) {
        return index < 0 || index >= size;
    }

    public int capacity() {
        return capacity;
    }
}
