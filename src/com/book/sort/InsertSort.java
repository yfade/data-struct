package com.book.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        System.out.println("直接插入排序--------------------");
        int[] arr = new int[]{3, 1, 4, 5, 6, 2};
        System.out.println(Arrays.toString(arr));
        directInsertSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("折半插入排序-------------------");
        arr = new int[]{3, 1, 4, 5, 6, 2};
        System.out.println(Arrays.toString(arr));
        BInsertSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("希尔排序-----------------------");
        arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        System.out.println(Arrays.toString(arr));
        int[] ins = new int[]{5, 3, 1};
        doShellInsertSort(arr, ins);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 直接插入排序
     *
     * @param arr
     */
    private static void directInsertSort(int[] arr) {
        if (checkArr(arr)) return;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {  //如果第i个元素比第i-1元素大则不需要处理,反之 则需要找到适当的位置进行插入操作
                int j = i - 1;
                int temp = arr[i];
                while (j != -1 && temp < arr[j]) {  //顺序查找需要插入的位置,并将数组元素进行后移,为插入元素腾出位置
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = temp;  //插入到正确位置
            }
        }
    }

    /**
     * 折半插入排序
     *
     * @param arr
     */
    private static void BInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int low = 0;
            int high = i - 1;
            int temp = arr[i];
            //采用折半法判断插入位置,最终变量low表示插入位置
            //当low==high时 low为小于temp的元素中的最接近temp的元素下标
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > temp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            //插入位置后的元素后移
            for (int j = i; j > low; j--) {
                arr[j] = arr[j - 1];
            }
            //插入元素
            arr[low] = temp;
        }
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    private static void shellInsertSort(int[] arr, int dk) {
        for (int i = dk; i < arr.length; i += dk) {
            if (arr[i] < arr[i - dk]) {
                int temp = arr[i];
                int j = i - dk;
                while (j >= 0 && temp < arr[j]) {
                    arr[j + dk] = arr[j];
                    j -= dk;
                }
                arr[j + dk] = temp;
            }
        }
    }

    private static void doShellInsertSort(int[] arr, int[] ins) {
        if (checkArr(arr)) {
            return;
        }
        for (int i : ins) {
            shellInsertSort(arr, i);
        }
    }

    private static boolean checkArr(int[] arr) {
        return arr == null || arr.length <= 1;
    }
}
