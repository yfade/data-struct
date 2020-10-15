package com.book.string;

import java.util.Arrays;

/**
 * 当前字符前 与后缀字符串相同的前缀字符串的最后一个字符的后一位所在位置。
 */
public class KMPMatch {
    public static void main(String[] args) {
//        char[] T = "abaabcac".toCharArray();
//        char[] T = new char[]{'a', 'a', 'a', 'c', 'd'};
        String str1 = "abcrbfabcaett";
        String str2 = "abcae";
//        String str2 = "aaaakk";
        System.out.println(doMatch(str1, str2));


    }

    private static int doMatch(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[] next = getNextArr(arr2);

        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (j == -1 || arr1[i] == arr2[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == arr2.length) {
            return i - j;
        }
        return -1;
    }

    private static int[] getNextArr(char[] T) {
        int[] next = new int[T.length];
        next[0] = -1;
        next[1] = 0;
        int i = 1;
        int j = 0;
        while (i < T.length - 1) {
            if (j == -1 || T[i] == T[j]) {
                i++;
                j++;
                //长串中正在比对的字符和模板串将要跳到的字符
                if (T[i] != T[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                //j=next[j] 的运用可以这样理解，每个字符对应的 next 值都可以表示该字符前 "同后缀字符串相同的前缀字符串最后一
                // 个字符所在的位置"，因此在每次匹配失败后，都可以轻松找到次长前缀字符串的最后一个字符与该字符进行比较
                j = next[j];
            }
        }

        System.out.println(Arrays.toString(next));
        return next;
    }
}
