package dsa;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size = 0;



    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        head = null;
    }

    public int size() {
        return size;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node<T> current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
        size++;
    }

    public T get(int index) {
        validateBounds(index);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) currentNode = currentNode.next;
        return currentNode.data;
    }

    private void validateBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: '" + index + "' out of bound for Size -> " + size);
        }
    }

    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            add(data);
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insert(T data, int index) {
        validateBounds(index);

        if (index == 0) {
            prepend(data);
            return;
        }

        if (index == size) {
            add(data);
            return;
        }


        Node<T> newNode = new Node<>(data);
        Node<T> previousNode = head;
        for (int i = 0; i < index - 1; i++) previousNode = previousNode.next;

        newNode.next = previousNode.next;
        previousNode.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("Cannot remove from an empty list.");

        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T removeLast() {
        if (size <= 1) return removeFirst();

        Node<T> current = head;
        while (current.next.next != null) current = current.next;
        T data = current.next.data;
        current.next = null;
        size--;

        return data;
    }

    public void clear() {
        head = null;
        size = 0;
    }

}
