package com.algorithm.binarytree;

import lombok.Data;

/**
 * AVL树节点
 */
@Data
public class AVLTreeNode<T> {
    // 父节点
    private AVLTreeNode<T> parent;
    // 左子树
    private AVLTreeNode<T> left;
    // 右子树
    private AVLTreeNode<T> right;
    // 平衡因子
    private Integer balanceFactor;
    // 节点数据
    private T value;
}
