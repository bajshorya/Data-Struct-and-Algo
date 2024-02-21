package com.dsashorya;

public class binarySearchTree {
    int val;
    binarySearchTree left, right;
    static binarySearchTree newNode(int item) {
        binarySearchTree temp = new binarySearchTree();
        temp.val = item;
        temp.left = temp.right = null;
        return temp;
    }

    static binarySearchTree insertIterative(binarySearchTree root, int val)
    {
        binarySearchTree newnode = new binarySearchTree();
        newnode.val=val;
        binarySearchTree x = root;
        if(root==null){
            return newnode;
        }
        while (true) {
            if (val < x.val)
            {
                if(x.left==null)
                {
                    x.left=newnode;
                    return root;
                }
                x=x.left;
            }
            else{
                if(x.right==null){
                    x.right=newnode;
                    return root;
                }
                x=x.right;
            }
        }
    }

    static binarySearchTree insert(binarySearchTree node, int val)
    {
        if (node == null)
            return newNode(val);

        if (val < node.val) {
            node.left = insert(node.left, val);
        }
        else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }
    static void inorder(binarySearchTree root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(" " + root.val);
            inorder(root.right);
        }
    }
    static void preOrder(binarySearchTree root)
    {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    static void postOrder(binarySearchTree root)
    {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" " + root.val);
        }
    }
    static int countLeafNodes(binarySearchTree node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }
    static boolean search(binarySearchTree node, int val) {
        if (node == null)
            return false;

        if (node.val == val)
            return true;

        if (val < node.val)
           return search(node.left, val);
        else
        return search(node.right, val);
    }


    public static void main(String[] args)
    {
        binarySearchTree root = null;
        root = insertIterative(root, 50);
        insertIterative(root, 30);
        insertIterative(root, 20);
        insertIterative(root, 60);
        insertIterative(root, 10);
        insertIterative(root, 40);
        insertIterative(root, 80);
        inorder(root);
        postOrder(root);
        preOrder(root);
    }
}


