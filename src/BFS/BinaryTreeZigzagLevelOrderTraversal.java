package BFS;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                tmp.add(n.val);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            if(!order) {
                Collections.reverse(tmp);
            }
            res.add(tmp);
            order = !order;
        }
        return res;
    }

}
