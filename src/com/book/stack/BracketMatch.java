package com.book.stack;


import java.util.Scanner;
import java.util.Stack;

public class BracketMatch {
    public static void main(String[] args) {
        String str = "";
        while (!"exit".equals(str)) {
            System.out.println("请输入需要匹配的字符串");
            Scanner scanner = new Scanner(System.in);
            str = scanner.next();
            System.out.println(matchBracket(str));
        }
    }

    public static boolean matchBracket(String str) {
        if (str == null || str.equals("")) {
            return true;
        }

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
            }
        }
        System.out.println("------------");
        return stack.isEmpty();
    }
}
