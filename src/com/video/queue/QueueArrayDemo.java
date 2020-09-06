package com.video.queue;

import java.util.Scanner;

public class QueueArrayDemo {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(3);

        Scanner scanner = new Scanner(System.in);
        char key = ' ';    //接受用户输入命令
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：向队列添加数据");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：显示队列头部数据");
            System.out.println("e(exit)：退出程序");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queueArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int val = scanner.nextInt();
                    queueArray.addQueue(val);
                    break;
                case 'g':
                    try {
                        int res = queueArray.getQueue();
                        System.out.printf("取出的数据是%d", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = queueArray.headQueue();
                        System.out.printf("头部数据是%d", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
            }
            System.out.println();
        }
    }
}

class QueueArray {
    private int maxSize;//队列最大长度
    private int front;  //队列头部
    private int rear;   //队列尾部
    private int[] arr;  //用于存放数据，模拟队列

    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        this.front = -1;    //指向队列头部，指向队列头部的前一个位置
        this.rear = -1;     //指向队列尾部，指向队列的最后一个数据位置
    }

    //判断是否队列已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int value) {
        if (isFull()) {
            System.out.println("队列已满~~");
            return;
        }
        arr[++rear] = value;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    //展示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i == arr.length - 1) {
                sb.append(']');
            } else {
                sb.append(',');
            }
        }
        System.out.println(sb);
    }

    //查看队列头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }


}
