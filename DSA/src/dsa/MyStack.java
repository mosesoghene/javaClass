package dsa;

public class MyStack {
    private MyArrayList stack = new MyArrayList();

    public void push(String value) {
        stack.add(value);
    }


    public int size() {
        return stack.size();
    }
}
