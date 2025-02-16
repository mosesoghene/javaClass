package ds;

public class MyArrayList {
    private int size = 0;
    private int capacity = 3;
    private String[] data = new String[capacity];

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(String element) {
        data[size] = element;
        size++;
        if (size == capacity) increaseCapacity();
    }

    private void increaseCapacity() {
        capacity *= 2;
        String[] tempArrayData = new String[capacity];
        System.arraycopy(data, 0, tempArrayData, 0, size);
        data = tempArrayData;
    }

    public int size() {
        return size;
    }

    public String get(int index) {
        return data[index];
    }
}
