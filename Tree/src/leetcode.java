import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode {
     public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  //100 
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // Both trees are empty (base case)
            return true;
        } else if (p == null || q == null) {
            // One tree is empty, the other is not
            return false;
        } else {
            // Compare current node values and recursively check left and right subtrees
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
    //94 inorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder=new ArrayList<Integer>();
        Stack <TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        while (true){
            if(node !=null){
                stack.push(node);
                node=node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node=stack.pop();
                inorder.add(node.val);
                node=node.right;
            }
        }
        return inorder;
    }

    // 101 Symmmetric tree
    public boolean isSymmetric(TreeNode root) {
       return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }

    //104 Maximum depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
                return 0;
        }else{
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}
// public boolean isPowerOfTwo(int n) {
//         if (n <= 0) {
//         return false; // If n is non-positive, it cannot be a power of two
//     }
//     // Keep dividing n by 2 until it becomes 1 or odd
//     while (n > 1) {
//         if (n % 2 != 0) {
//             return false; // If n is not divisible by 2, it's not a power of two
//         }
//         n /= 2;
//     }
//     return true;
//     }explain this