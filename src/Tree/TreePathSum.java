package Tree;

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
	 Given a binary tree and a sum, determine if the tree has a root-to-leaf path
	 such that adding up all the values along the path equals the given sum.

	 For example:
	 Given the below binary tree and sum = 22,
	 5
	 / \
	 4   8
	 /   / \
	 11  13  4
	 /  \      \
	 7    2      1
	 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
	 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	 For example:
	 Given the below binary tree and sum = 22,
	 5
	 / \
	 4   8
	 /   / \
	 11  13  4
	 /  \    / \
	 7    2  5   1
	 return
	 [
	 [5,4,11,2],
	 [5,8,4,5]
	 ]
	 */

	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
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
		if(root.left==null && root.right==null && root.val == sum){
			path.add(root.val);
			result.add(new ArrayList<Integer>(path));
			return;
		}

		//branch on subtrees
		path.add(root.val);
		pathSumHelper(root.left, sum-root.val, result, new ArrayList<>(path));
		pathSumHelper(root.right, sum-root.val, result, new ArrayList<>(path));

	}

}