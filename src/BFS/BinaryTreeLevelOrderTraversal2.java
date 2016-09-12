package BFS;

import java.util.*;

/**
 Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BinaryTreeLevelOrderTraversal2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> entry = new LinkedList<TreeNode>();
        entry.add(root);

        while(entry.isEmpty()==false){
            int len = entry.size();
            List<Integer> one = new LinkedList<Integer>();
            for(int i=0;i<len;i++){
                TreeNode temp = entry.poll();
                one.add(temp.val);
                if(temp.left!=null) entry.add(temp.left);
                if(temp.right!=null) entry.add(temp.right);
            }
            result.add(one);

        }
        Collections.reverse(result);
        return result;

    }
}
