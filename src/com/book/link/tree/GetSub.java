package com.book.link.tree;

/**
 * 列举集合 {1,2,3} 中所有子集
 * 回溯法
 */
public class GetSub {
    //数组中值为1的下标表示集合中的元素
    private static int[] arr = new int[3];

    public static void main(String[] args) {
        sub(0);
    }


    private static void sub(int i) {
        //说明数组的所有下标都有了对应的值，开始判断
        if (i > 2) {
            for (int j = 0; j < arr.length; j++) {
                //如果值为1，说明选取了该下标作为集合中的元素，输出
                if (arr[j] == 1) {
                    System.out.print(j + 1 + "\t");
                }
            }
            System.out.println();
            return;
        }

        //选中该元素，该下标对应的值赋为1，继续向下探索
        arr[i] = 1;
        sub(i + 1);

        //取消选中该元素，该下标的值设为0，继续向下探索
        arr[i] = 0;
        sub(i + 1);
    }
}
