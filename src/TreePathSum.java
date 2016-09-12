import java.util.*;

public class TreePathSum{

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	/**
	 *
	 *     Given a binary tree and a sum, determine if the tree has a root-to-leaf path
	  		such that adding up all the values along the path equals the given sum.
	 */
public boolean hasPathSum(TreeNode root, int sum){
	if(root == null){
		return false;
	}
	//root-to-leaf path sum found
	if(root.val==sum && root.left==null && root.right==null){
		return true;
	}
    //continue to check left/right subtree with new sum
	return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
}


	/**
	 *
	 //Given a binary tree and a sum, find all root-to-leaf paths
	 //where each path's sum equals the given sum.
	 */


	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		pathSumHelper(root, sum, result, path);
		return result;
	}

	public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> result, ArrayList<Integer> path){
		if(root == null){
			return;
		}

		//reach a leaf

		if(root.left==null && root.right==null){

			//find path sum
			if(root.val == sum){
				path.add(root.val);
				result.add(new ArrayList<Integer>(path));
				path.remove(path.size()-1);
			}
			return;
		}

		//branch on subtrees
		path.add(root.val);
		pathSumHelper(root.left, sum-root.val, result, path);
		pathSumHelper(root.right, sum-root.val, result, path);
		path.remove(path.size()-1);
	}

//	For this problem, a path is defined as 
//	any sequence of nodes from some starting node to any node in the tree along the 
//	parent-child connections. 
//	The path does not need to go through the root.
	
	
//	binary tree maximum path sum
	 public int maxPathSum(TreeNode root) {
	        int[] re = helper(root);
	        return re[0];
	    }
	    
	    public int[] helper(TreeNode root){
	        int[] result = {Integer.MIN_VALUE,0};
	        if(root==null) return result;
	        
	     
	        int[] lr = helper(root.left);
	        int[] rr = helper(root.right);
	        
	            result[1] = Math.max(lr[1]+root.val,rr[1]+root.val);
	            result[1] = Math.max(result[1],0);
	            
	            result[0] = Math.max(lr[0],rr[0]);
	            result[0] = Math.max(result[0],lr[1]+rr[1]+root.val);
	        
	        //System.out.println(result[0]);
	        return result;
	    }
	
}