package com.datastruct.link.reverse;

public class Link {
    private Node first;
    private int size;

    public void add(int val) {
        Node node = new Node(val, null);
        if (first == null) {
            first = node;
        } else {
            Node temp = first;
            for (int i = 0; i < size - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(val, null);
        }
        size++;
    }

    /**
     * 迭代反转
     */
    public void iterationReverse() {
        if (first == null || first.next == null) {
            return;
        }
        Node begin = null;
        Node mid = first;
        Node end = first.next;

        while (true) {
            mid.next = begin;
            if (end == null) {
                break;
            }
            begin = mid;
            mid = end;
            end = end.next;
        }
        first = mid;
    }

    @Override
    public String toString() {
        Node temp = first;
        StringBuilder sb = new StringBuilder("[");
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

    static class Node {
        private int item;
        private Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


}
