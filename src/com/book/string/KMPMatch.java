package com.book.string;

import java.util.Arrays;

public class KMPMatch {
    public static void main(String[] args) {
//        char[] T = "abaabcac".toCharArray();
        char[] T = new char[]{'a', 'a', 'a', 'c', 'd'};
//        char[] T = new char[]{'a', 'b', 'c', 'a', 'e'};
        int[] next = new int[T.length];
        next[0] = -1;
        next[1] = 0;
        int i = 1;
        int j = 0;
        while (i < T.length - 1) {
            if (j == -1 || T[i] == T[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        System.out.println(Arrays.toString(next));
    }
}
