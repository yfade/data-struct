package com.book.link;

public class LinkList {
    private int size;
    private Node first;
    private Node last;

    public boolean add(int val) {
        linkLast(val);
        return true;
    }

    public boolean add(int index, int val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index:" + index + " size:" + size);
        }
        Node newNode = new Node(val, null);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
            size++;
            return true;
        }
        if (index == size) {
            linkLast(val);
            return true;
        }
        Node temp = first;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return true;
    }

    public int remove(int index) {
        checkBound(index);
        int oldVal;
        if (index == 0) {
            oldVal = first.item;
            first = first.next;
            size--;
            return oldVal;
        }
        Node temp = first;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node rNode = temp.next;
        oldVal = rNode.item;
        temp.next = rNode.next;
        size--;
        return oldVal;
    }

    private void checkBound(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index:" + index + " size:" + size);
        }
    }

    public int get(int index) {
        checkBound(index);
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    void linkLast(int val) {
        final Node l = last;
        final Node newNode = new Node(val, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (first != null) {
            sb.append(temp.item);
            if (temp.next == null) {
                return sb.append(']').toString();
            }
            sb.append(',');
            temp = temp.next;
        }
        return sb.append(']').toString();
    }

    private static class Node {
        private int item;
        private Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}
