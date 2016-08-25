/**
 * Problem: find the first common ancestor of two nodes in a binary tree
 *          avoid store additional nodes in data stucture
 * Solution 3: if no link to parents, define a function that 
 *             a) return x(y) if subtree has x but not y(x)
 *             b) return null if subtree doesn't have both x and y
 *             c) otherwise, return common ancestor
 */

public class commonAncestor{
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[8];
		for(int i=0; i<nodes.length; i++){
			nodes[i] = new TreeNode(i);
		}
		nodes[0].setChild(nodes[1],nodes[2]);
		nodes[1].setChild(nodes[3],nodes[4]);
		nodes[4].setChild(nodes[5],nodes[6]);
        TreeNode ancestor = ancestor2(nodes[0],nodes[3],nodes[6]);
        if(ancestor != null){
        	System.out.println(ancestor.print());
        }
	}
    
//	Given a binary search tree (BST), 
//	find the lowest common ancestor (LCA) of two given nodes in the BST.
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val<p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else if (root.val>p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else return root;
        
        
    }
	
//	Given a binary tree, 
//	find the lowest common ancestor (LCA) of two given nodes in the tree.	
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode x, TreeNode y) {
		       if(root == null){
					return null;
				}

				if(root==x || root==y){
					return root;
				}

				TreeNode left_lca = lowestCommonAncestor(root.left, x, y);
				TreeNode right_lca = lowestCommonAncestor(root.right, x, y);
				if(left_lca!=null && right_lca!=null){
					return root;
				}
				return left_lca!=null ? left_lca : right_lca;
		    }
    }



}