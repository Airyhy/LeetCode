package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
 1
   \
    2
  /
 3
 return [1,3,2].
 */
public class BinaryTreeInorderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    //Recursive

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;

    }


    //iteratively
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        //left -- root -- right
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }
}
