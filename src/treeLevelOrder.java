/**
* Problem: Level order traversal of a binary tree
*
* Solution: for each level, use queuefind all nodes in the next level, then add current level to list
*/
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;


https://leetcode.com/submissions/detail/49862923/
public class treeLevelOrder{
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
}