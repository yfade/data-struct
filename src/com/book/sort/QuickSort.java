package com.book.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 5, 6, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int low, int high) {
        int p = arr[low];
        while (low < high) {
            while (low < high && arr[high] > p) {
                high--;
            }
            arr[low] = arr[high];

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
            int index = partition(arr, low, high);

            quickSort(arr, low, index - 1);

            quickSort(arr, index + 1, high);
        }
    }

    private static void swapItem(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

}
