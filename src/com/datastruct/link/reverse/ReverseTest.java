package com.datastruct.link.reverse;

public class ReverseTest {
    public static void main(String[] args) {
        Link link = new Link();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        System.out.println(link);
        link.iterationReverse();
        System.out.println(link);
    }
}
