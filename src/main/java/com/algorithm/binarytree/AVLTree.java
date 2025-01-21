package com.algorithm.binarytree;

/**
 * AVL Tree
 */
public class AVLTree{
    // the root node of the tree
     private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public AVLTree() {
    }

    public AVLTree(Node root) {
        this.root = root;
    }

    /**
     * Insert value into the AVL tree
     * @param value The value of Node
     * @return true or false
     */
    public boolean insert(Long value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }
        Node parent = null;
        Node current = root;

        while (current != null) {
            if (value < current.value) {
                parent = current;
                current = current.left;
            }else if (value > current.value) {
                parent = current;
                current = current.right;
            }else {
                // Neither greater than nor less than the value, indicates the value already exists.
                return false;
            }
        }
        // The current node is empty, and the inserted value needs to be linked to the current node
        current = new Node(value);

        // Determine whether the current node is linking in the left or right of the parent node
        if (value < parent.value) {
            parent.left = current;
        }else {
            parent.right = current;
        }
        // Link the parent node of the current node
        current.parent = parent;

        return true;
    }


    /**
     * AVL Tree Node
     */
    static class Node {
        private Node parent;
        private Node left;
        private Node right;
        private Integer balanceFactor;
        private final Long value;

        public Node(Long value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Integer getBalanceFactor() {
            return balanceFactor;
        }

        public void setBalanceFactor(Integer balanceFactor) {
            this.balanceFactor = balanceFactor;
        }

        public Long getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(100L);
        tree.insert(80L);
        tree.insert(103L);
        tree.insert(90L);
        System.out.println(tree);
    }
}
