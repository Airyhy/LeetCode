package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameOrSymmetricTree{


	public class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	/**
	 *
	 * Given two binary trees, write a function to check if they are equal or not.

	 	Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	 */
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p==null && q==null){
			return true;
		}
		if(p==null || q==null){
			return false;
		}else{
			return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		}
	}




	public boolean isSameTree2(TreeNode p, TreeNode q){
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.offer(p);
		q2.offer(q);

		while(!q1.isEmpty() && !q2.isEmpty()){
			TreeNode x = q1.poll();
			TreeNode y = q2.poll();

			if(x == null){
				if(y != null){
					return false;
				}else{
					continue;
				}
			}

			if(y == null || x.val!=y.val){
				return false;
			}

			q1.offer(x.left);
			q1.offer(x.right);
			q2.offer(y.left);
			q2.offer(y.right);
		}
		return true;
	}

	/**
	 *
	 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

	 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

	 1
	 / \
	 2   2
	 / \ / \
	 3  4 4  3
	 But the following [1,2,2,null,3,null,3] is not:
	 1
	 / \
	 2   2
	 \   \
	 3    3

	 */
	
	//	Symmetric tree
	 public boolean isSymmetric(TreeNode root) {
	        // Write your code here
	        if(root==null){
	            return true;
	        }
	        return DFS(root.left,root.right);
	    }
	    
	    public boolean DFS(TreeNode root1,TreeNode root2){
	        if(root1==null && root2==null){
	            return true;
	        }else if(root1==null || root2==null){
	            return false;
	        }
	        
	        if(root1.val!=root2.val){
	            return false;
	        }
	        
	        return DFS(root1.left,root2.right)&&DFS(root1.right,root2.left);
	    }
}