package com.book.link.doublelinked;

import com.sun.deploy.util.UpdateCheck;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 5);
        list.add(0, 6);
        list.add(4, 99);
        list.add(6, 8);
        System.out.println(list.size());
        System.out.println(list);
        list.remove(6);
        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.update(5, 22));
        System.out.println(list);
    }
}

class DoubleLinkedList {
    private Node first;
    private Node last;
    private int size;
    private int modCount;

    public void add(int data) {
        addLast(data);
    }

    private void addLast(int data) {
        final Node l = last;
        final Node newNode = new Node(l, data, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
        }
        if (index == size) {
            addLast(data);
        } else {
            Node succ = node(index);
            Node prev = succ.prev;
            Node newNode = new Node(prev, data, succ);
            succ.prev = newNode;
            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
            size++;
            modCount++;
        }
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
        }
        Node node = node(index);
        final int oldValue = node.item;
        final Node prev = node.prev;
        final Node next = node.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.prev = null;
        }
        node.item = 0;
        size--;
        modCount++;
        return oldValue;
    }


    public int update(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
        }
        Node node = node(index);
        final int oldVal = node.item;
        node.item = data;
        modCount++;
        return oldVal;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node temp = first;
        while (temp != null) {
            sb.append(temp.item);
            if (temp.next == null) {
                return sb.append(']').toString();
            }
            sb.append(',');
            temp = temp.next;
        }
        return sb.append(']').toString();
    }

    private Node node(int index) {
        if (index < (size >> 1)) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    public int size() {
        return size;
    }

    static class Node {
        private Node prev;
        private int item;
        private Node next;

        public Node(Node prev, int item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
