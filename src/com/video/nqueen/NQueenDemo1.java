package com.video.nqueen;

import java.util.Arrays;

public class NQueenDemo1 {
    private static int count;

    public static void main(String[] args) {
        int n = 8;
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = -1;
        }
        solution(board, 0, n);
        System.out.println(count);
    }

    private static void solution(int[] board, int row, int n) {
        if (row == n) {
            count++;
            System.out.println(Arrays.toString(board));
            System.out.println("--------------------------------------");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(board, row, i)) {
                board[row] = i;
                solution(board, row + 1, n);
                board[row] = -1;
            }
        }
    }

    private static boolean isValid(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            int item = board[i];
            if (col == item || Math.abs(row - i) == Math.abs(col - item)) {
                return false;
            }
        }
        return true;
    }
}
