package com.book.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("冒泡插入排序-------------------");
        int[] arr = new int[]{3, 1, 4, 5, 6, 2};
//        int[] arr = new int[]{1, 2, 3, 4, 6, 5};
        System.out.println(Arrays.toString(arr));
        bubbleSort3(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if (checkArr(arr)) {
            return;
        }
        //每循环一次就在未排序的元素中找出一个最大值放到数组后面，当找出arr.length-1个后最后那个就是正确的位置
        for (int i = 0; i < arr.length - 1; i++) {
            //已找出的最大值不再参与比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序-优化1
     * 假设我们现在排序ar[]={1,2,3,4,5,6,7,8,10,9}这组数据，按照上面的排序方式，第一趟排序后将10和9交换已经有序，接下来的8趟排序就是多余的，
     * 什么也没做。所以我们可以在交换的地方加一个标记，如果那一趟排序没有交换元素，说明这组数据已经有序，不用再继续下去。
     *
     * @param arr
     */
    private static void bubbleSort1(int[] arr) {
        if (checkArr(arr)) {
            return;
        }
        //每循环一次就在未排序的元素中找出一个最大值放到数组后面，当找出arr.length-1个后最后那个就是正确的位置
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            //已找出的最大值不再参与比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 冒泡排序-优化2
     * 优化一仅仅适用于连片有序而整体无序的数据(例如：1， 2，3 ，4 ，7，6，5)。
     * 但是对于前面大部分是无序而后边小半部分有序的数据(1，2，5，7，4，3，6，8，9，10)排序效率也不可观，
     * 对于种类型数据，我们可以继续优化。既我们可以记下最后一次交换的位置，后边没有交换，必然是有序的，然后下一次排序从第一个比较到上次记录的位置结束即可。
     *
     * @param arr
     */
    private static void bubbleSort2(int[] arr) {
        if (checkArr(arr)) {
            return;
        }

        int len = arr.length - 1;
        int pos = 0;    //记录最后一次交换位置
        //每循环一次就在未排序的元素中找出一个最大值放到数组后面，当找出arr.length-1个后最后那个就是正确的位置
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            //已找出的最大值不再参与比较
            for (int j = 0; j < len; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                    pos = j;
                }
            }
            if (!flag) {
                break;
            }
            len = pos; //直接跳到最后一次发生交换位置
        }
    }

    /**
     * 冒泡排序-优化3
     * 优化二的效率有很大的提升，还有一种优化方法可以继续提高效率。大致思想就是一次排序可以确定两个值，
     * 正向扫描找到最大值交换到最后，反向扫描找到最小值交换到最前面。例如：排序数据1，2，3，4，5，6，0
     *
     * @param arr
     */
    private static void bubbleSort3(int[] arr) {
        if (checkArr(arr)) {
            return;
        }

        int len = arr.length - 1;
        int pos = 0;    //记录最后一次交换位置
        int pos1 = 0; //反向最后一次交换下标
        int len1 = 0;
        //每循环一次就在未排序的元素中找出一个最大值放到数组后面，当找出arr.length-1个后最后那个就是正确的位置
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            //已找出的最大值不再参与比较
            for (int j = 0; j < len; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                    pos = j;
                }
            }
            if (!flag) {
                return;
            }
            len = pos; //直接跳到最后一次发生交换位置

            flag = false;
            for (int j = len; j > len1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                    pos1 = j;
                }
            }
            len1 = pos1;
            if (!flag) {
                return;
            }
        }
    }


    private static boolean checkArr(int[] arr) {
        return arr == null || arr.length <= 1;
    }
}
