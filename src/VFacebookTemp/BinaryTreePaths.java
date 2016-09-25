package VFacebookTemp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ret = new ArrayList<String>();
        if(root == null){
            return ret;
        }

        dfs(root, new StringBuilder(), ret);
        return ret;
    }

    public void dfs(TreeNode root, StringBuilder sb, List<String> ret){

        if(root.left == null && root.right == null){
            sb.append(root.val);
            ret.add(sb.toString());
            return;
        }

        sb.append(root.val);
        sb.append("->");

        if(root.left != null){
            dfs(root.left, new StringBuilder(sb), ret);
        }

        if(root.right != null){
            dfs(root.right, new StringBuilder(sb), ret);
        }
    }
}
