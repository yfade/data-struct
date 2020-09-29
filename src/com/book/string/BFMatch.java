package com.book.string;

public class BFMatch {
    public static void main(String[] args) {
        String a = "abefcdefgh";
        String b = "efgh";
        System.out.println(bfMatch(a, b));

    }

    private static int bfMatch(String a, String b) {
        if (b.length() > a.length()) {
            return -1;
        }
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int i = 0;
        int j = 0;
        while (i < arrA.length && j < arrB.length) {
            char c1 = arrA[i];
            char c2 = arrB[j];
            if (c1 == c2) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == arrB.length) {
            return i - j;
        }
        return -1;

    }
}
