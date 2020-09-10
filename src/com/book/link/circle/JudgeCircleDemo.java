package com.book.link.circle;


public class JudgeCircleDemo {
    public static void main(String[] args) {
        JudgeCircle circle = new JudgeCircle();
        circle.init();
        System.out.println(circle.hasCircle());
    }
}

/**
 * 有关在有环链表中 H1 和 H2 必定会相遇的结论， 假设有环链表中的环包含 n 个节点， 则第一
 * 次遍历， H1 和 H2 相差 1 个节点； 第二次遍历， H1 和 H2 相差 2 个节点； 第三次遍历， H1
 * 和 H2 相差 3 个节点...， 最终经过多次遍历， H1 和 H2 会相差 n-1 个节点， 此时就会在环中
 * 重合， 此时 H1 和 H2 相等。
 */
class JudgeCircle {
    private Node head;

    public void init() {
        head = new Node(1, null);
        Node node2 = new Node(2, null);
        head.next = node2;
        Node node3 = new Node(3, null);
        node2.next = node3;

        Node temp = node3;
        for (int i = 4; i < 10; i++) {
            temp.next = new Node(i, null);
            temp = temp.next;
        }
        temp.next = node3;
    }

    /**
     * 判断链表中是否有环
     *
     * @return
     */
    public boolean hasCircle() {
        if (head == null) {
            return false;
        }
        Node n1 = head.next;
        Node n2 = head;
        while (n1 != null) {
            if (n1 == n2) {
                return true;
            }
            n1 = n1.next;
            if (n1 == null) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return false;
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

