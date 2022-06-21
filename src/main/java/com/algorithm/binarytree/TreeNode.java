package com.algorithm.binarytree;

import lombok.Data;

/**
 * @author liuzhaowei
 * @date 2022/6/15 13:17
 */
@Data
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    /**
     * 生成二叉搜索树
     * @param ary
     * @return
     */
      public static TreeNode generateTreeNode(int[] ary){
          TreeNode root = new TreeNode();
          root.val = ary[0];
          for (int i=1; i<ary.length; i++) {
              int temp = ary[i];
              addOne(root, temp);
          }
          return root;
      }

      public static void addOne(TreeNode node, int temp) {
          if (temp > node.val) {
              // 挂在右节点
              if (node.right != null) {
                  addOne(node.right, temp);
              }else {
                  TreeNode treeNode = new TreeNode();
                  treeNode.val = temp;
                  node.right = treeNode;
              }
          }else {
              // 挂在左节点
              if (node.left != null) {
                  addOne(node.left, temp);
              }else {TreeNode treeNode = new TreeNode();
                  treeNode.val = temp;
                  node.left = treeNode;
              }
          }
      }
}
