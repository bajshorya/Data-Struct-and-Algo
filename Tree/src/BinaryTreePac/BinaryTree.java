package BinaryTreePac;
import java.util.Scanner;
public class BinaryTree {
    private static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val=val;
        }
    }
    private Node root;
    //insert Elements with taking input scanner
    public void populate(Scanner scanner){
        System.out.println("Enter the root node of the binary tree: ");
        int val=scanner.nextInt();
        //the first element that has to be scanned is the root
        root=new Node(val);
        //calls the private populate method to continue populating the tree recursively.
        populate(scanner,root);
    }
    private void populate(Scanner scanner,Node node){
        System.out.println("Do you wanna enter the left of the node ->" +node.val);
        //if true the recursive call weill be called, and you will have to input the left  value of the node
        //if false you have to input the right value of the node ,if false again then the right value of the parent node
        //and then the continuation of the whole recursive process
        boolean left=scanner.nextBoolean();
        if (left){
            System.out.println("Enter the value of the left of ->" +node.val);
            int val= scanner.nextInt();
            node.left=new Node(val);
            populate(scanner,node.left);
        }
        System.out.println("Do you wanna enter the right of the node ->" +node.val);
        boolean right=scanner.nextBoolean();
        if (right){
            System.out.println("Enter the value of the right of ->" +node.val);
            int val=scanner.nextInt();
            node.right=new Node(val);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(root," ");
    }
    private void display(Node node, String indent) {
        if (node==null){
            return;
        }
        System.out.println(indent+node.val);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
    public int findHeight(Node node) {
        if (node == null) {
            return -1; // Base case: height of an empty tree is -1
        } else {
            int leftHeight = findHeight(node.left);
            int rightHeight = findHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1; // Height is maximum of left and right subtrees + 1 for the current node
        }
    }
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.val);
        } else {
            System.out.println(node.val );
        }
        prettyDisplay(node.left, level + 1);
    }
}
