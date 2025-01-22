package dsa;

public class MyQueue {
    private String[] strings;
    private final int front = 0;
    private int rear = 0;

    public MyQueue(int capacity) {
        this.strings = new String[capacity];
    }


    public int capacity() {
        return strings.length;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void enqueue(String element) {
        strings[rear++] = element;
    }

    public String dequeue() {
        String element = strings[front];
        updateQueue();
        return element;
    }

    private void updateQueue() {
        for (int i = 0; i < rear; ) {
            strings[i] = strings[++i];
        }
        if (rear > 0) rear--;
    }

    public int size() {
        return rear;
    }

    public String peek(){
        return strings[front];
    }
}
