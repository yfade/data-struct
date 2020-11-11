package com.book.link.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 哈夫曼树
 */
public class HuffManTree {
    public static void main(String[] args) {
        //初始化树结点
        List<Node<String>> nodes = new ArrayList<>(4);
        nodes.add(new Node<>("a", 7));
        nodes.add(new Node<>("b", 5));
        nodes.add(new Node<>("c", 2));
        nodes.add(new Node<>("d", 4));

        //构造哈夫曼树
        Node<String> rootNode = createHuffManTree(nodes);

        //遍历哈夫曼树
        breadthFirst(rootNode);
    }

    /**
     * 构造哈夫曼树
     *
     * @param nodes 节点集合
     * @return 哈夫曼树的根结点
     */
    private static Node<String> createHuffManTree(List<Node<String>> nodes) {
        while (nodes.size() > 1) {
            //从大到小排序
            doQuickSort(nodes);

            int size = nodes.size();
            //取出最小的两个结点
            Node<String> leftNode = nodes.get(size - 1);
            Node<String> rightNode = nodes.get(size - 2);

            //生成新的结点，新结点的权值为两个子结点权值的和
            Node<String> parentNode = new Node<>(null, leftNode.weight + rightNode.weight);
            //让新结点作为两个权值最小的结点的父结点
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            //移除两个权值最小的几点，并将新结点放入list中
            nodes.remove(size - 1);
            nodes.remove(size - 2);
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }


    /**
     * 广度优先遍历
     *
     * @param node 根结点
     */
    private static void breadthFirst(Node<String> node) {
        Queue<Node<String>> queue = new ArrayDeque<>(10);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node<String> temp = queue.poll();
            System.out.println(temp.data);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    private static void doQuickSort(List<Node<String>> nodes) {
        quickSort(nodes, 0, nodes.size() - 1);
    }

    /**
     * 快速排序
     *
     * @param nodes
     * @param low
     * @param high
     */
    private static void quickSort(List<Node<String>> nodes, int low, int high) {
        if (low < high) {
            int index = partition(nodes, low, high);
            quickSort(nodes, low, index - 1);
            quickSort(nodes, index + 1, high);
        }
    }


    private static int partition(List<Node<String>> nodes, int low, int high) {
        Node<String> p = nodes.get(low);
        while (low < high) {
            while (low < high && nodes.get(high).weight < p.weight) {
                high--;
            }
            nodes.set(low, nodes.get(high));

            while (low < high && nodes.get(low).weight > p.weight) {
                low++;
            }
            nodes.set(high, nodes.get(low));
        }
        nodes.set(low, p);
        return low;
    }


    static class Node<E> {
        E data;
        int weight;
        Node<E> left;
        Node<E> right;

        public Node(E data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }
}
