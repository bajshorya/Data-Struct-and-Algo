package ques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class avgLevelElements637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Double> levelOrder(TreeNode root) {
        List<Double> result=new ArrayList<>();
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
            //initialising a variable with value 0
            double averageLevel= 0;
            //running a loop through the size of the level
            for (int i = 0; i < levelSize; i++) {
                //making currentNode(Treenode) object and storing the
                // polled value from the queue
                TreeNode currentNode= queue.poll();
                //adding the value to the currentNode to averageLevel variable
                //till the loop end(size of the level) (the variable was
                //initialised from 0)
                averageLevel+= currentNode.val;
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
            //averaging the total of the averageLevel variable to it's size
            averageLevel=averageLevel/levelSize;
            result.add(averageLevel);
        }
        return result;
    }
}

