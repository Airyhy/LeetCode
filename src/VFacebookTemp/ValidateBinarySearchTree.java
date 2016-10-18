package VFacebookTemp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    //O(n), space: O(logn), worst: O(n)
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



    //O(n), space: O(logn), worst: O(n)
    //use inorder traversal iterate
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;
        TreeNode node = root;
        while (node!= null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            node = stack.pop();
            if (pre != null && node.val <= pre.val) {
                return false;
            }
            pre = node;
            node = node.right;
        }
        return true;
    }


}