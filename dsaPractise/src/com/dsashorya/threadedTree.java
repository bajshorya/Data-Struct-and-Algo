package com.dsashorya;

class TreeNode {
    int data;
    TreeNode left, right;
    boolean isThreaded;
    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
        isThreaded = false;
    }
}

public class threadedTree {
    private TreeNode root;
    public threadedTree() {
        root = null;
    }
    public void insert(int data) {
        root = insertRec(root, data);
    }
    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
            if (root.right == null) {
                root.right = root;
                root.isThreaded = true;
            }
        } else if (data > root.data) {
            if (!root.isThreaded) {
                root.right = insertRec(root.right, data);
            } else {
                TreeNode temp = new TreeNode(data);
                temp.right = root.right;
                root.right = temp;
                root.isThreaded = false;
            }
        }
        return root;
    }
    public void printInOrder() {
        TreeNode current = leftMost(root);
        while (current != null) {
            System.out.print(current.data + " ");
            if (current.isThreaded) {
                current = current.right;
            } else {
                current = leftMost(current.right);
            }
        }
    }
    private TreeNode leftMost(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public static void main(String[] args) {
        threadedTree tree = new threadedTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(3);

        System.out.println("In-order threaded binary tree:");
        tree.printInOrder();
    }
}

