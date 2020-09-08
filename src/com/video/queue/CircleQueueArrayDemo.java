package com.video.queue;

import java.util.Scanner;

public class CircleQueueArrayDemo {
    public static void main(String[] args) {
        CircleQueueArray queue = new CircleQueueArray(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';    //接受用户输入命令
        boolean loop = true;
        while (loop) {
            System.out.println("d(display)：显示队列");
            System.out.println("a(add)：向队列添加数据");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：显示队列头部数据");
            System.out.println("l(last)：显示队列尾部数据");
            System.out.println("s(size)：显示队列元素个数");
            System.out.println("e(exit)：退出程序");
            key = scanner.next().charAt(0);

            switch (key) {
                case 'd':
                    System.out.println(queue);
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int val = scanner.nextInt();
                    queue.push(val);
                    break;
                case 'g':
                    try {
                        int res = queue.pop();
                        System.out.printf("取出的数据是%d", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.head();
                        System.out.printf("头部数据是%d", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'l':
                    try {
                        int res = queue.last();
                        System.out.printf("尾部数据是%d", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 's':
                    System.out.printf("队列元素个数：%d", queue.size());
                    break;
                case 'e':
                    loop = false;
                    break;
            }
            System.out.println();
        }
    }
}

class CircleQueueArray {
    private int front;  //指向第一个数据元素
    private int rear;   //指向最后一个数据元素的后一个位置
    private int[] arr;
    private int maxSize;

    public CircleQueueArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    private boolean isEmpty() {
        return rear == front;
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("循环队列已满");
            return;
        }
        arr[rear] = val;
        rear = (rear + 1) % maxSize;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("循环队列为空");
        }
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("循环队列为空");
        }
        return arr[front];
    }

    public int last() {
        if (isEmpty()) {
            throw new RuntimeException("循环队列为空");
        }
        return arr[rear - 1];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        int f = front;
        int r = rear;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            sb.append(arr[f]);
            f = (f + 1) % maxSize;
            if (f == r) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
