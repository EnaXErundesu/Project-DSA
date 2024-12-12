package org;

public class LinkedStack<E> {
    private SinglyLinkedList<E> sll = new SinglyLinkedList<>();

    // Constructor
    public LinkedStack() {
        // Default constructor
    }

    // Pushes an element onto the stack
    public void push(E e) {
        sll.addFirst(e);
    }

    // Pops and returns the top element of the stack
    public E pop() {
        return sll.removeFirst();
    }

    // Returns the size of the stack
    public int size() {
        return sll.size();
    }

    // Peeks at the top element of the stack without removing it
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return sll.getHead().getElement();
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return sll.isEmpty();
    }
}
