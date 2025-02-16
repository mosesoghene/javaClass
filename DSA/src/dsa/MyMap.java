package dsa;

public class MyMap {
    private final MySet keys = new MySet();
    private final MyArrayList values = new MyArrayList();

    public void put(String key, String value) {
        keys.add(key);

        int position = keys.indexOf(key);
        values.update(position, value);
    }

    public int size() {
        return keys.size();
    }
}
