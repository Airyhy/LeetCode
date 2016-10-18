package Tree;

/**
 * 给定一个BST的root，找从root到leaves的权值最小的路径。不要求返回路径，只要求返回路径上节点值的sum。
 * 要求这个sum最小。用divide and conquer就行。注意这题有null node，以及它的null left和null right。。。这结构见了鬼

 */
public class BinarySearchTreeMinPathSum {


    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public static int minPath1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.right == null) {
            return root.val + minPath1(root.left);
        }
        if (root.left == null) {
            return root.val + minPath1(root.right);
        }
        return Math.min(minPath1(root.left), minPath1(root.right)) + root.val;
    }




    static int minSum;
    public static int minPath(TreeNode root) {
        minSum = Integer.MAX_VALUE;
        DFS(root, 0);
        return minSum;
    }

    private static void DFS(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;

        if (root.left == null && root.right == null) {
            minSum = Math.min(minSum, currentSum);
            return;
        }
        DFS(root.left, currentSum);
        DFS(root.right, currentSum);
    }
}
