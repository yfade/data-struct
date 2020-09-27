package com.book.stack;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.display();
        System.out.println(stack.pop());
        stack.display();
        System.out.println(stack.pop());
        stack.display();
    }
}

class LinkedStack<E> {
    private Node<E> head;
    private int size;

    public void push(E e) {
        head = new Node<>(e, head);
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("size :" + size);
        }
        final Node<E> topNode = head;
        final E topData = topNode.data;

        head = head.next;
        topNode.data = null;
        topNode.next = null;
        size--;
        return topData;
    }

    public void display() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.printf(temp.data.toString() + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
