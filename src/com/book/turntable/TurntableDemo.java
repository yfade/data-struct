package com.book.turntable;

import java.util.ArrayList;
import java.util.Random;

public class TurntableDemo {
    public static void main(String[] args) {
        Game1 game1 = new Game1();
        game1.play(6);
    }
}


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
