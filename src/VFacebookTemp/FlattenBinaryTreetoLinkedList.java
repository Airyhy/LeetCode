package VFacebookTemp;

import java.util.Stack;

/**
 *Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

    1
   / \
  2   5
  / \   \
  3   4   6
 The flattened tree should look like:
 1-2-3-4-5-6
 click to show hints.

 Hints:
 If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

 */

public class FlattenBinaryTreetoLinkedList {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //O(n), O(height)
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }


    //O(n), O(height)
    //iterative
    public void flatten1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right != null) {
                stk.push(curr.right);
            }
            if (curr.left != null) {
                stk.push(curr.left);
            }
            if (!stk.isEmpty()) {
                curr.right = stk.peek();
            }
            curr.left = null;
        }
    }
}
