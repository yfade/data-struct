package com.book.link.tree;

public class ThreadTree {
    private static ThreadNode pre;

    public static void main(String[] args) {
        ThreadNode tree = initTree();
        inThread(tree);
        threadTraverse(tree);
    }

    private static void threadTraverse(ThreadNode t) {
        while (t != null) {
            while (!t.lFlag) {
                t = t.lc;
            }
            System.out.print(t.data + "\t");
            while (t.rFlag && t.rc != null) {
                t = t.rc;
                System.out.print(t.data + "\t");
            }
            t = t.rc;
        }
    }


    /**
     * 中序对二叉树线索化
     *
     * @param node
     */
    private static void inThread(ThreadNode node) {
        if (node == null) {
            return;
        }
        //递归当前左子树进行线索化
        inThread(node.lc);
        //如果当前节点没有左孩子，左标志位设为true，左孩子只想上一节点pre
        if (node.lc == null) {
            node.lFlag = true;
            node.lc = pre;
        }
        //如果pre没有右孩子，右标志位设为true，右孩子指向当前节点
        if (pre != null && pre.rc == null) {
            pre.rFlag = true;
            pre.rc = node;
        }
        //线索完左子树后，pre只想当前节点
        pre = node;
        //递归右子树进行线索化
        inThread(node.rc);
    }

    private static ThreadNode initTree() {
        ThreadNode treeNode4 = new ThreadNode(4, null, null);
        ThreadNode treeNode5 = new ThreadNode(5, null, null);
        ThreadNode treeNode6 = new ThreadNode(6, null, null);
        ThreadNode treeNode7 = new ThreadNode(7, null, null);

        ThreadNode treeNode2 = new ThreadNode(2, treeNode4, treeNode5);
        ThreadNode treeNode3 = new ThreadNode(3, treeNode6, treeNode7);

        ThreadNode treeNode1 = new ThreadNode(1, treeNode2, treeNode3);
        return treeNode1;
    }

}

class ThreadNode {
    int data;
    boolean lFlag;
    boolean rFlag;
    ThreadNode lc;
    ThreadNode rc;

    public ThreadNode(int data, ThreadNode lc, ThreadNode rc) {
        this.data = data;
        this.lFlag = lFlag;
        this.rFlag = rFlag;
        this.lc = lc;
        this.rc = rc;
    }
}
