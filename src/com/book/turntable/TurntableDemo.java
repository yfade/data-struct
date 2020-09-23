package com.book.turntable;

import java.util.ArrayList;
import java.util.Random;

public class TurntableDemo {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(6));
        }
    }
}


class Game1 {
    private int[] arr;

    public void play(int size) {
        if (size < 2) {
            throw new RuntimeException("size=" + size);
        }
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }

        while (size != 1) {
            Random random = new Random();
            int failNum = random.nextInt(size);

            if (failNum >= size) {
                failNum = failNum % size;
            }
            int failPeo = arr[failNum];
            for (int i = failNum; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        }
    }
}
