package com.book.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 5, 6, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分割的过程
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        int p = arr[low];   //支点
        while (low < high) {
            //将比支点小的元素放在左侧
            while (low < high && arr[high] > p) {
                high--;
            }
            arr[low] = arr[high];
            //将比支点大的元素放在右侧
            while (low < high && arr[low] < p) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = p;
        return low;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            //找到支点位置
            int index = partition(arr, low, high);
            //对支点左侧子表排序
            quickSort(arr, low, index - 1);
            //对指点右侧子表排序
            quickSort(arr, index + 1, high);
        }
    }

    private static void swapItem(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

}
