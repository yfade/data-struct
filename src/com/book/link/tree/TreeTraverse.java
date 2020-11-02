package com.book.link.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeTraverse {
    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);

        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);

        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println("先序遍历：");
        beforeTraverse(treeNode1);
        System.out.println();
        beforeTraverseStack(treeNode1);
        System.out.println();

        System.out.println("中序遍历:");
        midTraverse(treeNode1);
        System.out.println();

        System.out.println("后续遍历：");
        afterTraverse(treeNode1);
        System.out.println();

        System.out.println("层次遍历");
        levelTraverse(treeNode1);
        System.out.println();
    }

    /**
     * 先序遍历-递归
     *
     * @param treeNode
     */
    private static void beforeTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        displayTreeNode(treeNode);
        beforeTraverse(treeNode.lc);
        beforeTraverse(treeNode.rc);
    }

    /**
     * 先序遍历-非递归
     *
     * @param treeNode
     */
    private static void beforeTraverseStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            while (pop != null) {
                displayTreeNode(pop);
                if (pop.rc != null) {
                    stack.push(pop.rc);
                }
                pop = pop.lc;
            }
        }
    }

    /**
     * 中序遍历-递归
     *
     * @param treeNode
     */
    private static void midTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midTraverse(treeNode.lc);
        displayTreeNode(treeNode);
        midTraverse(treeNode.rc);
    }

    /**
     * 后续遍历
     *
     * @param treeNode
     */
    private static void afterTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        afterTraverse(treeNode.lc);
        afterTraverse(treeNode.rc);
        displayTreeNode(treeNode);
    }

    /**
     * 层次遍历
     *
     * @param treeNode
     */
    private static void levelTraverse(TreeNode treeNode) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            displayTreeNode(node);
            if (node.lc != null) {
                queue.add(node.lc);
            }
            if (node.rc != null) {
                queue.add(node.rc);
            }
        }
    }

    private static void displayTreeNode(TreeNode treeNode) {
        System.out.print(treeNode.data + "\t");
    }
}

class TreeNode {
    int data;
    TreeNode lc;
    TreeNode rc;

    public TreeNode(int data, TreeNode lc, TreeNode rc) {
        this.data = data;
        this.lc = lc;
        this.rc = rc;
    }
}
