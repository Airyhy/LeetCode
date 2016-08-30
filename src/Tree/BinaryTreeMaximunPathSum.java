package Tree;

/**
 *
 Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node
 in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

  1
 / \
 2   3

 Return 6.

 */
public class BinaryTreeMaximunPathSum {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] re = helper(root);
        return re[0];
    }

    public int[] helper(TreeNode root){
        int[] result = {Integer.MIN_VALUE,0};
        if(root==null) return result;


        int[] lr = helper(root.left);
        int[] rr = helper(root.right);

        result[1] = Math.max(lr[1]+root.val,rr[1]+root.val);
        result[1] = Math.max(result[1],0);

        result[0] = Math.max(lr[0],rr[0]);
        result[0] = Math.max(result[0],lr[1]+rr[1]+root.val);

        return result;
    }
}
