package com.dsashorya;

public class ThreadedSearchTree {
    int val;
    ThreadedSearchTree left, right;
    boolean leftThread,rightThread;
    static ThreadedSearchTree insertIterative(ThreadedSearchTree root, int val)
    {
        ThreadedSearchTree newnode = new ThreadedSearchTree();
        newnode.val=val;
        newnode.left=newnode.right=null;
        newnode.leftThread=newnode.rightThread=true;
        ThreadedSearchTree x = root;
        if(root==null){
            return newnode;
        }
        while (true) {
            if (val < x.val)
            {
                if(x.leftThread)
                {
                    newnode.left=x.left;
                    x.left=newnode;
                    newnode.right=x;
                    x.leftThread=false;
                    return root;
                }
                x=x.left;
            }
            else{
                if(x.rightThread){
                    newnode.right=x.right;
                    x.right=newnode;
                    newnode.left=x;
                    x.rightThread=false;
                    return root;
                }
                x=x.right;
            }
        }
    }

    static public void printInOrder(ThreadedSearchTree root) {
        ThreadedSearchTree current = leftMost(root);
        while (current != null) {
            System.out.print(current.val + " ");
            if (current.rightThread) {
                current = current.right;
            } else {
                current = leftMost(current.right);
            }
        }
    }
    static private ThreadedSearchTree leftMost(ThreadedSearchTree node) {
        if (node == null) {
            return null;
        }
        while (!node.leftThread) {
            node = node.left;
        }
        return node;
    }



    public static void main(String[] args)
    {
        ThreadedSearchTree root = null;
        root = insertIterative(root, 50);
        insertIterative(root, 30);
        insertIterative(root, 20);
        insertIterative(root, 60);
        insertIterative(root, 10);
        insertIterative(root, 40);
        insertIterative(root, 80);
        printInOrder(root);
    }
}


