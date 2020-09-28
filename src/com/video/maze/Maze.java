package com.video.maze;

import java.lang.reflect.MalformedParameterizedTypeException;

public class Maze {
    public static void main(String[] args) {
        int[][] map = initMap(8, 7);
        displayMap(map);
        boolean play = play(map, 1, 1);
        System.out.println("-------------------" + play);
        displayMap(map);
    }

    /**
     * 规则：1：墙 2：已走过 3：不通
     * 行走策略 下->右->上->左
     *
     * @param map
     * @param x
     * @param y
     * @return
     */
    private static boolean play(int[][] map, int x, int y) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[x][y] == 0) {
            map[x][y] = 2;
            if (play(map, x + 1, y)) {
                return true;
            }
            if (play(map, x, y + 1)) {
                return true;
            }
            if (play(map, x - 1, y)) {
                return true;
            }
            if (play(map, x, y - 1)) {
                return true;
            }
            map[x][y] = 3;
            return false;
        }
        return false;
    }

    private static int[][] initMap(int x, int y) {
        int[][] map = new int[x][y];
        for (int i = 0; i < y; i++) {
            map[0][i] = 1;
            map[x - 1][i] = 1;
        }
        for (int i = 0; i < x; i++) {
            map[i][0] = 1;
            map[i][y - 1] = 1;
        }
//        map[3][1] = 1;
//        map[3][2] = 1;

//        map[1][2] = 1;
//        map[2][2] = 1;

//        map[4][2] = 1;
//        map[4][3] = 1;
//        map[4][4] = 1;
//        map[5][4] = 1;
//        map[6][4] = 1;
        /*map[2][2]=1;
        map[3][2]=1;
        map[4][2]=1;
        map[5][2]=1;
        map[6][2]=1;

        map[2][4]=1;
        map[3][4]=1;
        map[4][4]=1;
        map[5][4]=1;
        map[6][4]=1;*/

        map[6][4] = 1;
        map[5][4] = 1;
        map[5][5] = 1;
        return map;
    }

    private static void displayMap(int[][] map) {
        for (int[] arr : map) {
            for (int i : arr) {
                System.out.printf(i + "\t");
            }
            System.out.println();
        }
    }
}
