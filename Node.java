package org;

class Node<E> {
    private E element;
    private Node<E> next;

    // Constructor
    public Node(E e, Node<E> next) {
        this.element = e;
        this.next = next;
    }

    // Getter for element
    public E getElement() {
        return element;
    }

    // Getter for next node
    public Node<E> getNext() {
        return next;
    }

    // Setter for next node
    public void setNext(Node<E> next) {
        this.next = next;
    }
}
