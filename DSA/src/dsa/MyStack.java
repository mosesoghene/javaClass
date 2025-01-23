package dsa;

public class MyStack {
    private MyArrayList stack = new MyArrayList();

    public void push(String value) {
        stack.add(value);
    }

    public int size() {
        return stack.size();
    }

    public String pop() throws Exception {
        String element = stack.get(size() - 1);
        stack.remove(element);
        return element;
    }

    public String peek() throws Exception {
        return stack.get(size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
