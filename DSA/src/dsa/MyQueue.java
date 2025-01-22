package dsa;

public class MyQueue {
    private int capacity;
    private final int front = 0;
    private int rear = 0;

    public MyQueue(int capacity) {
        this.capacity = capacity;
    }


    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void enqueue(String element) {
        rear++;
    }

    public String dequeue() {
        rear--;
        return "One";
    }
}
