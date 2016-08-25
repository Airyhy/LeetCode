//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as 
//a binary tree in which the depth of the two subtrees of 
//every node never differ by more than 1.

// https://leetcode.com/problems/balanced-binary-tree/

public class BalancedBinaryTree{
	   public boolean isBalanced(TreeNode root) {
	        // write your code here
	        if(root==null) return true;
	        
	        int depl = tranver(root.left,0);
	        int depr = tranver(root.right,0);
	        
	        
	        if(depl<0 || depr<0 || Math.abs(depl-depr)>1){
	            return false;
	        }
	        return true;
	    }
	    
	    public int tranver (TreeNode root,int dep){
	        if (root==null){
	            return dep;
	        }
	        dep++;
	        int depl = tranver(root.left,dep);
	        int depr = tranver(root.right,dep);
	        
	        if(depl<0 || depr<0 || Math.abs(depl-depr)>1){
	            return -1;
	        }
	        
	        return Math.max(depl,depr);
	    }
}