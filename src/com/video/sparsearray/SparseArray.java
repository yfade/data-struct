package com.video.sparsearray;

import java.io.*;

/**
 * 稀疏数组
 * <p>
 * 将二维数组压缩放入稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //原始棋盘
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][6] = 2;
        chessArr[7][1] = 1;

        //获取二维数组不同值的个数
        System.out.println("原始数组---------------------");
        int sum = 0;
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
                if (data != 0) {
                    sum++;
                }
            }
            System.out.println();
        }

        //创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                int data = chessArr[i][j];
                if (data != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = data;
                    count++;
                }
            }
        }

        System.out.println("稀疏数组------------------------------------");
        //写入文件
        File file = new File("C:/Users/daibi/Desktop/temp/five");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(sum + 1 + " " + 3 + "\r\n");
        for (int[] row : sparseArr) {
            System.out.printf("%d\t%d\t%d\n", row[0], row[1], row[2]);
            String str = row[0] + " " + row[1] + " " + row[2] + "\r\n";
            fileWriter.write(str);
        }
        fileWriter.close();

        System.out.println("稀疏数组写入文件---");

        //从文件中读取数组
        FileReader fileReader = new FileReader(file);
        BufferedReader bf = new BufferedReader(fileReader);
        String firstLine = bf.readLine();
        String[] firstArr = firstLine.split(" ");
        Integer readX = Integer.valueOf(firstArr[0]);
        Integer readY = Integer.valueOf(firstArr[1]);
        int[][] readArr = new int[readX][readY];
        String line;
        int lineCount = 0;
        while ((line = bf.readLine()) != null) {
            String[] arr = line.split(" ");
            for (int i = 0; i < arr.length; i++) {
                readArr[lineCount][i] = Integer.valueOf(arr[i]);
            }
            lineCount++;
        }
        bf.close();

        System.out.println("从文件中读取稀疏数组---------------");
        for (int[] row : readArr) {
            System.out.printf("%d\t%d\t%d\n", row[0], row[1], row[2]);
        }


        //将二维数组还原
        System.out.println("二维数组还原---------------------------");
        int rowNum = readArr[0][0];
        int colNum = readArr[0][1];
        int[][] restoreArr = new int[rowNum][colNum];
        for (int i = 1; i < readArr.length; i++) {
            int x = readArr[i][0];
            int y = readArr[i][1];
            int val = readArr[i][2];
            restoreArr[x][y] = val;
        }

        for (int[] row : restoreArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
