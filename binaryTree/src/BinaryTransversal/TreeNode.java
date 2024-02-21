package BinaryTransversal;

import java.util.*;
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
     static class Solution {

      public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> preorder = new ArrayList<Integer>();
          if (root == null) {
              return preorder;
          }
          Stack<TreeNode> st = new Stack<TreeNode>();
          st.push(root);
          while (!st.isEmpty()) {
              root = st.pop();
              preorder.add(root.val);
              if (root.right != null) {
                  st.push(root.right);
              }
              if (root.left != null) {  // Change this line to check the left child
                  st.push(root.left);
              }
          }
          return preorder;
      }
  }
}
