package com.book.datastructure.link;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(1);
        linkList.add(3);
        System.out.println(linkList.size());
        System.out.println(linkList);
        linkList.add(2, 2);
        System.out.println(linkList.size());
        System.out.println(linkList);

        linkList.remove(0);
        System.out.println(linkList.size());
        System.out.println(linkList);

        System.out.println(linkList.get(0));
    }
}
