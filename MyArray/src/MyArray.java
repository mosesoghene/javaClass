import java.util.HashMap;
import java.util.Map;

public class MyArray {
    private HashMap<Integer, Integer> array;
    private final int size;
    private int currentIndex = 0;

    public MyArray(int size) {
        array = new HashMap<>();
        this.size = size;
    }

    public void push(int value) {
        if (array.size() == size) throw new IndexOutOfBoundsException();
        array.put(currentIndex++, value);
    }

    public void pop() {
        if (array.isEmpty()) throw new IndexOutOfBoundsException();
        int value = array.get(--currentIndex);
        array.remove(value);
    }

    public int peek() {
        if (array.isEmpty()) throw new IndexOutOfBoundsException();
        return array.get(currentIndex - 1);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int size() {
        return array.size();
    }

    public void insert(int value, int position) {
        if (array.size() == this.size) throw new IndexOutOfBoundsException();

        int currentValue = value;

        while (array.containsKey(position)) {
            int temp = array.get(position);

            array.put(position, currentValue);

            currentValue = temp;
            position++;
        }

        array.put(position, currentValue);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i + 1 < array.size()) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void remove(int index) {
        if (array.isEmpty() || index >= this.size) throw new IndexOutOfBoundsException();
        array.remove(index);

        Map<Integer, Integer> copy = new HashMap<>(array);
        array.clear();
        currentIndex = 0;
        for (Map.Entry<Integer, Integer> entry : copy.entrySet()) {
            array.put(currentIndex++, entry.getValue());
        }
    }

    public Integer get(int index) {
        if (array.isEmpty() || index >= this.size) throw new IndexOutOfBoundsException();
        return array.get(index);
    }

    public void clear() {
        array.clear();
    }

    public boolean contains(int value) {
        return array.containsValue(value);
    }




    public static void main(String[] args) {
        MyArray myArray = new MyArray(5);
        myArray.push(10);
        myArray.push(12);
        myArray.push(13);

        System.out.println(myArray);
        myArray.insert(11, 1);
        System.out.println(myArray);
        myArray.remove(1);
        System.out.println(myArray);
        System.out.println(myArray.get(1));

    }
}
