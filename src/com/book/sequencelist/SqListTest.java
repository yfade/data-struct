package com.book.sequencelist;

public class SqListTest {
    public static void main(String[] args) {
        SequenceList sequenceList = new SequenceList(3);
        for (int i = 1; i < 15; i++) {
            sequenceList.add(i);
        }
        System.out.println(sequenceList.size());
        System.out.println(sequenceList.length());
        System.out.println(sequenceList);
        sequenceList.add(2, 33);
        System.out.println(sequenceList);
        sequenceList.remove(5);
        System.out.println(sequenceList);
        sequenceList.set(10, 30);
        System.out.println(sequenceList);
        System.out.println(sequenceList.get(2));
    }
}
