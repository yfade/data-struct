package com.book.link.reverse;

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

    /**
     * 递归反转
     */
    public void recursionReverse() {
        first = recursionReverse(first);
    }

    public Node recursionReverse(Node head) {
        //递归出口
        if (head == null || head.next == null) {
            return head;
        }
        //一直递归，找到最后一个结点
        Node lastNode = recursionReverse(head.next);

        //lastNode始终指向原链表中最后一个结点，head的下一个结点指向head，head指向NULL
        head.next.next = head;
        head.next = null;

        return lastNode;
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
