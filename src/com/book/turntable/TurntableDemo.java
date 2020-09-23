package com.book.turntable;

import java.util.Random;

public class TurntableDemo {
    public static void main(String[] args) {
        /*Game1 game1 = new Game1();
        game1.play(6);*/

        Game2 game2 = new Game2();
        game2.play(6);
    }
}

/**
 * 顺序表实现
 */
class Game1 {
    private int[] arr;

    public void play(int size) {
        checkSize(size);
        initArr(size);
        display();

        int beg = 0;
        Random random = new Random();
        while (size != 1) {
            int failNum = random.nextInt(size);
            System.out.printf("从第%d个人开始，第%d枪会饷\n", beg + 1, failNum + 1);
            //找到出局人
            failNum += beg;
            if (failNum >= size) {
                failNum = failNum % size;
            }
            int failPeo = arr[failNum];
            for (int i = failNum; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[--size] = 0;
            System.out.printf("%d号出局\n", failPeo);
            display();
            if (failNum == size) {
                beg = 0;
            } else {
                beg = failNum;
            }
        }
        System.out.printf("胜者为%d号", arr[0]);
    }

    private void initArr(int size) {
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
    }

    public void display() {
        for (int i : arr) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
        System.out.println("----------------------------");
    }

    private void checkSize(int size) {
        if (size < 2) {
            throw new RuntimeException("size=" + size);
        }
    }
}

/**
 * 链表实现
 */
class Game2 {
    private Node first;

    public void play(int size) {
        checkSize(size);
        initList(size);
        display();

        Node beg = first;
        Random random = new Random();
        while (first != first.next) {
            int failNum = random.nextInt(size) + 1;
            System.out.printf("从第%d号开始，第%d枪会响\n", beg.item, failNum);

            //找到出局人的前一个人
            if (failNum == 1) {
                Node temp = beg;
                while (temp.next != beg) {
                    temp = temp.next;
                }
                beg = temp;
            } else {
                for (int i = 1; i < failNum - 1; i++) {
                    beg = beg.next;
                }
            }

            final Node temp = beg.next;
            beg.next = temp.next;
            beg = beg.next;
            if (first == temp) {
                first = temp.next;
            }
            System.out.printf("%d号出局\n", temp.item);
            temp.item = 0;
            temp.next = null;
            display();
            size--;
        }
        System.out.printf("胜者为%d号\n", beg.item);
    }

    private void checkSize(int size) {
        if (size < 2) {
            throw new RuntimeException("size=" + size);
        }
    }

    private void initList(int size) {
        first = new Node(1, null);
        Node temp = first;
        for (int i = 1; i < size; i++) {
            Node node = new Node(i + 1, null);
            temp.next = node;
            temp = temp.next;
        }
        temp.next = first;
    }

    private void display() {
        if (first == first.next) {
            System.out.print(first.item + "\t\n");
            System.out.println("---------------------------------");
            return;
        }
        Node temp = first;
        while (true) {
            if (temp.next == first) {
                System.out.print(temp.item + "\t");
                break;
            }
            System.out.print(temp.item + "\t");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("---------------------------------");
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
