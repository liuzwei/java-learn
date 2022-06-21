package com.algorithm.center;

import com.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @author liuzhaowei
 * @date 2022/6/20 13:43
 */
public class LeetCode230 {

    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        int result = 0;
        int r = 0;
        while (root != null || !deque.isEmpty()) {
            // 先遍历左子树，直到左子树为空
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (k == ++r) {
                result = root.val;
                break;
            }
            if (root.right != null) {
                root = root.right;
            }else {
                root = null;
            }
        }

        return result;
    }


    /**
     * 中序遍历，第K个数
     * 利用二叉搜索数的特性，中序遍历后，即可得到一个顺序的List，取第K个数，就是第K小的数。
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        return travlese(root).get(k-1);
    }

    private List<Integer> travlese(TreeNode node){
        List<Integer> rese = new ArrayList<>();

        if (node.left != null) {
            rese.addAll(travlese(node.left));
        }
        if (node.left== null && node.right == null) {
            rese.add(node.val);
            return rese;
        }
        rese.add(node.val);
        if (node.right != null) {
            rese.addAll(travlese(node.right));
        }
        return rese;
    }

    public static void main(String[] args) {
        LeetCode230 leetCode230 = new LeetCode230();
        int[] ary = new int[]{5,3,6,2,4,1};
        TreeNode treeNode = TreeNode.generateTreeNode(ary);

        List<Integer> travlese = leetCode230.travlese(treeNode);
        System.out.println(travlese);
    }


}
