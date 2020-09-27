package com.book.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.display();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.display();
    }
}

class ArrayStack {
    private int[] arr;
    private int top;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.arr = new int[maxSize];
        this.maxSize = maxSize;
        this.top = -1;
    }

    public int push(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("stack is full maxSize:" + maxSize);
        }
        arr[++top] = item;
        return item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int val = arr[top];
        arr[top--] = 0;
        return val;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println();
    }


    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}


