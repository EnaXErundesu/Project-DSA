package org;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private int size;

    // Constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // Adds an element at the beginning of the list
    public void addFirst(E e) {
        head = new Node<>(e, head);
        size++;
    }

    // Removes and returns the first element of the list
    public E removeFirst() {
        if (isEmpty()) return null;
        E element = head.getElement();
        head = head.getNext();
        size--;
        return element;
    }

    // Returns the size of the list
    public int size() {
        return size;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Getter for the head node
    public Node<E> getHead() {
        return head;
    }
}
