package com.book.search;

/**
 * 折半查找
 */
public class SearchBin {

    public static void main(String[] args) {
        int[] arr = {5, 21, 13, 19, 37, 75, 56, 64, 88, 80, 92};
        int index = search(arr, 75);
        System.out.println(index);

    }

    private static int search(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            int item = arr[mid];
            if (item == x) {
                return mid;
            }

            if (x > item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
