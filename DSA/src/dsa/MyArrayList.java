package dsa;

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

    public void insert(int index, String element) {
        String currentElement = element;
        while (elements[index] != null) {
            String temp = elements[index];
            elements[index++] = currentElement;
            currentElement = temp;
        }
        elements[index] = currentElement;
        size++;
    }


    public void remove(String element) throws Exception {
        int index = findIndexOf(element);
        if (index == -1) throw new Exception("Element not found");

        updateListFrom(index);

    }

    private int findIndexOf(String element) {
        for (int index = 0; index < size; index++) {
            if (element.equals(elements[index])) return index;
        }
        return -1;
    }

    private void updateListFrom(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[++index];
        }
        elements[index] = null;
        --size;
    }

    public boolean contains(String element) {
        for(String item: elements) {
            if (element.equals(item)) return true;
        }
        return false;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (!(i + 1 == size)) sb.append(elements[i]).append(", ");
            else sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
