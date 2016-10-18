package VFacebookTemp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    //O(n)
    //recursion
    public List<String> binaryTreePaths1(TreeNode root) {

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


    //O(n)
    //recursion
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for (int i = 0; i < left.size(); i++) {
            list.add(root.val + "->"+ left.get(i));
        }
        for (int j = 0; j < right.size(); j++) {
            list.add(root.val + "->"+ right.get(j));
        }
        return list;
    }



    //bfs
    public List<String> binaryTreePathsBFS(TreeNode root) {
        if (root == null) {return new ArrayList<>();}
        List<String> ret = new ArrayList<>();
        Queue<TreeNodeWrapper> que = new LinkedList<>();
        que.add(new TreeNodeWrapper(root, String.valueOf(root.val)));
        while (!que.isEmpty()) {
            TreeNodeWrapper nodeWrapper = que.poll();
            String path = nodeWrapper.path;
            TreeNode node = nodeWrapper.node;
            if (node.left != null) {
                TreeNodeWrapper leftWrapper = new TreeNodeWrapper(node.left, path + "->" + node.left.val);
                que.add(leftWrapper);
            }
            if (node.right != null) {
                TreeNodeWrapper leftWrapper = new TreeNodeWrapper(node.right, path + "->" + node.right.val);
                que.add(leftWrapper);
            }
            if (node.right == null && node.left == null) {
                ret.add(path);
            }
        }
        return ret;
    }


    class TreeNodeWrapper {
        TreeNode node;
        String path;

        TreeNodeWrapper(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }
}
