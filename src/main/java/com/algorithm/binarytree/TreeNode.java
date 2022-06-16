package com.algorithm.binarytree;

import lombok.Data;

/**
 * @author liuzhaowei
 * @date 2022/6/15 13:17
 */
@Data
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      public TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
