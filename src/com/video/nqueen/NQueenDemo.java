package com.video.nqueen;

public class NQueenDemo {
    public static void main(String[] args) {
        int n = 8;
        int[][] board = new int[n][n];
        solve(board, 0, n);

    }

    private static void solve(int[][] board, int row, int n) {
        if (row == n) {
            display(board);
            System.out.println("--------------------------------------");
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 1;
                solve(board, row + 1, n);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isValid(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (j == col || Math.abs(row - i) == Math.abs(col - j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int i : row) {
                System.out.printf(i + "\t");
            }
            System.out.println();
        }
    }
}
