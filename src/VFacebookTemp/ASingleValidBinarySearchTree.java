package VFacebookTemp;

import java.util.*;

/**
 * Given a set of Tree Nodes,
 * find if they form a single valid BST, if so return the root
 */

public class ASingleValidBinarySearchTree {

    public TreeNode findSingleBST(Set<TreeNode> set) {
        if (set == null) {
            return null;
        }

        TreeNode root = null;
        for (TreeNode node : new HashSet<>(set)) {
            if (set.contains(node)) {
                root = node;

                // dfs
                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);
                while (!stack.isEmpty()) {
                    TreeNode current = stack.pop();
                    if (current != root) {
                        set.remove(current);
                    }
                    if (current.left != null) {
                        stack.push(current.left);
                    }
                    if (current.right != null) {
                        stack.push(current.right);
                    }
                }
            }
        }

        if (set.size() > 1) {
            return null;
        }
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
