package ques;


import java.util.*;

public class levelOrderTrav {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {

      }
      TreeNode(int val) {
          this.val = val;
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            //the size of the current level will be equal to the
            //size of the queue eg 1st level size =1
            //second level = 2 (queue size 2 )
            int levelSize=queue.size();
            //the inner list = list of elements on the level (current)
            //so it will be of the size of that level
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            //running a loop through the size of the level
            for (int i = 0; i < levelSize; i++) {
            //making currentNode(Treenode) object and storing the
            // polled value from the queue
                TreeNode currentNode= queue.poll();
            //adding the value to the currentLevel List
                currentLevel.add(currentNode.val);
            //if the left and right side of the currentNode is
            //not null then offering them to the "queue"
            //so that this loop can be run again on that element
            //i.e. making the level of the same size of that level
            //and all the elements of that level can be stored in the currentLevel list
                if (currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            //adding the elements stored of the list "currentLevel"
            //to the final result list
            result.add(currentLevel);
        }
        return result;
    }
}
