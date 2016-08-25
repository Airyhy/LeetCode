


/**
* Problem: Zigzag level order traversal of a binary tree
*
* Solution: Use two stacks, one to store node in current level and another one to store nodes
* in next level. Use a boolean to flag if we will visit from right next time, if so
* push left child first and then right child. Alternate order after visiting each level.
*/

import java.util.*;
public class TreeLevelZigzagOrder{
	
//level order traverse
//	Given a binary tree, return the level order traversal of its nodes' values. 
//			(ie, from left to right, level by level).
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> entry = new LinkedList<TreeNode>();
        entry.add(root);
        
        while(entry.isEmpty()==false){
           int len = entry.size();
           List<Integer> one = new LinkedList<Integer>();
           for(int i=0;i<len;i++){
               TreeNode temp = entry.poll();
               one.add(temp.val);
               if(temp.left!=null) entry.add(temp.left);
               if(temp.right!=null) entry.add(temp.right);
           }
           result.add(one);
           
        }
        return result;
    }

 
//    Given a binary tree, return the zigzag level order traversal of its nodes' values. 
//   (ie, from left to right, then right to left for the next level and alternate between).
 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        
        List<List<Integer>> res = new ArrayList<>(); 
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;
    
        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if(order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
	}
}