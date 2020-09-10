package com.book.link.circle;

public class CircleLinkDemo {
    public static void main(String[] args) {
        CycleLink cycleLink = new CycleLink();
        cycleLink.initLink();
        System.out.println(cycleLink);
        cycleLink.findAndRemove(3, 2);
        System.out.println(cycleLink);
    }

}

class CycleLink {
    private int size;
    private Node first;
    private Node last;

    public void initLink() {
        first = new Node(1, null);
        Node temp = first;
        for (int i = 2; i <= 5; i++) {
            temp.next = new Node(i, null);
            temp = temp.next;
            last = temp;
        }
        last.next = first;
        size = 5;
    }

    public void findAndRemove(int k, int m) {
        Node temp = first;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        System.out.println("编号为%d的人开始数数");
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < m - 2; i++) {
                temp = temp.next;
            }
            Node rNode;
            if (temp == temp.next) {
                rNode = temp;
                first = null;
                flag = false;
                System.out.printf("最后%d出列\n", temp.item);
            } else {
                rNode = temp.next;
                temp.next = rNode.next;
                temp = temp.next;
                System.out.printf("%d出列\n", rNode.item);
            }
            rNode.item = 0;
            rNode.next = null;
        }

    }

    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node temp = first;
        boolean flag = true;
        while (flag) {
            sb.append(temp.item);
            temp = temp.next;
            if (temp == last) {
                flag = false;
                sb.append(',').append(temp.item);
                sb.append(']');
            } else {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    class Node {
        private int item;
        private Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}

