package VFacebookTemp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree{

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

	//recursive
    public boolean isValidBST1(TreeNode root) {
        return helper(root,null,null);
    }


    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root==null)  return true;
        if( (min!=null && root.val<=min) || (max!=null && root.val>=max)){
            return false;
        }
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }

    


     //use inorder traversal to convert it to a list first
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> result = new ArrayList<Integer>();
        inOrderList(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    public void inOrderList(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderList(root.left, res);
        res.add(root.val);
        inOrderList(root.right, res);
    }

}