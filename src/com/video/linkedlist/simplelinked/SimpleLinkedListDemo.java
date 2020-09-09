package com.video.linkedlist.simplelinked;

public class SimpleLinkedListDemo {
    public static void main(String[] args) {
        SimpleLinkedList<Hero> list = new SimpleLinkedList<>();
        list.remove(new Hero(3, "", ""));
        Hero h1 = new Hero(1, "宋江", "及时雨");
        Hero h2 = new Hero(2, "卢俊义", "玉麒麟");
        Hero h3 = new Hero(3, "吴用", "智多星");
        Hero h4 = new Hero(4, "林冲", "豹子头");
//        list.add(h1);
//        list.add(h3);
//        list.add(h2);

        list.addByOrder(h1);
        list.addByOrder(h3);
        list.addByOrder(h3);
        list.addByOrder(h2);
        list.addByOrder(h4);
        list.list();

        Hero updateHero = new Hero(2, "卢俊义~~", "玉麒麟");
        Hero update = list.update(updateHero);
        System.out.println(update.getName() + " 已被修改");
        list.list();
        list.remove(new Hero(1, "", ""));
        list.list();
    }
}

class SimpleLinkedList<E extends Hero> {
    private int size;   //链表长度
    private Node<E> head;  //头结点，不存储数据，仅表示链表的头

    public SimpleLinkedList() {
        head = new Node<>();
    }

    public void add(E e) {
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node<E> newNode = new Node<>(e);
        temp.next = newNode;
        size++;
    }

    public void addByOrder(E e) {
        Node<E> temp = head;
        Node<E> newNode = new Node<>(e);
        while (true) {
            if (temp.next == null) {
                temp.next = newNode;
                return;
            }
            int no = temp.next.item.getNo();
            if (no == e.getNo()) {
                System.out.println("该英雄已存在，无法插入");
                return;
            }
            if (no > e.getNo()) {
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }

    public E update(E e) {
        E oldItem;
        Node<E> temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("未找到修改项");
                return null;
            }
            int no = temp.item.getNo();
            if (no == e.getNo()) {
                oldItem = temp.item;
                temp.item = e;
                return oldItem;
            }
            temp = temp.next;
        }
    }

    public void remove(E e) {
        Node<E> temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("未找到删除项");
                return;
            }
            Node<E> rNode = temp.next;
            if (rNode.item.getNo() == e.getNo()) {
                temp.next = rNode.next;
                rNode.item = null;
                rNode.next = null;
                return;
            }
            temp = temp.next;
        }
    }


    public void list() {
        if (head.next == null) {
            System.out.println("[]");
            return;
        }
        Node<E> temp = head.next;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            sb.append(temp.item);
            if (temp.next == null) {
                sb.append(']');
                System.out.println(sb);
                return;
            }
            sb.append(',');
            temp = temp.next;
        }
    }


    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.item = e;
            this.next = next;
        }

        public Node(E e) {
            this.item = e;
        }

        public Node() {
        }
    }
}
