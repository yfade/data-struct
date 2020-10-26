package com.book.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 5, 6, 2};
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int[] tempArr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, tempArr, low, mid);  //左边归并排序，使左子序列有序
            mergeSort(arr, tempArr, mid + 1, high); //右边归并排序，使右子序列有序
            merge(arr, tempArr, low, mid, high);    //合并两个子序列
        }
    }

    private static void merge(int[] arr, int[] tempArr, int low, int mid, int high) {
        int i = low, j = mid + 1;   //左右子序列起始索引
        int k = 0;  //临时数组索引起始位置

        //合并左子序列和右子序列
        while (i <= mid && j <= high) {
            if (arr[i] > arr[j]) {
                tempArr[k++] = arr[j++];
            } else {
                tempArr[k++] = arr[i++];
            }
        }

        //合并左边序列剩余的元素
        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }
        //合并右边序列剩余的元素
        while (j <= high) {
            tempArr[k++] = arr[j++];
        }

        //将临时数组中的元素拷贝覆盖到原数组
        for (int l = 0; l < k; l++) {
            arr[low + l] = tempArr[l];
        }

    }


}
