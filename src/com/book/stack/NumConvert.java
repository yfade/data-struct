package com.book.stack;

import java.util.Scanner;

public class NumConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字");
        int a = scanner.nextInt();
        System.out.println("请输入要转换的进制");
        int b = scanner.nextInt();
        int resNum = getResNum(a, b);
        System.out.println(resNum);
    }

    private static int getResNum(int a, int b) {
        if (a == 0 || b == 10) {
            return a;
        }
        ArrayStack stack = new ArrayStack(10);
        while (a != 0) {
            stack.push(a % b);
            a /= b;
        }

        stack.display();
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return Integer.valueOf(res.toString());
    }
}
