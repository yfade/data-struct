package com.book.link.reverse;

public class ReverseTest {
    public static void main(String[] args) {
        Link link = new Link();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        System.out.println("原链表：");
        System.out.println(link);

        System.out.println("迭代反转：");
        link.iterationReverse();
        System.out.println(link);

        System.out.println("递归反转：");
        link.recursionReverse();
        System.out.println(link);

        System.out.println("头插法反转：");
        link.topInsertReverse();
        System.out.println(link);
    }
}
