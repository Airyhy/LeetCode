package Tree;

/**
 *  The amplitude of path P is the maximum
 difference between values of nodes on path P
 * that, given a tree T consisting of N nodes, returns the amplitude of T.
 */
public class AmplitudeofTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static int amplitude;
    public static int getAmplitudeOfTree(TreeNode root) {
        amplitude = 0;
        DFS(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return amplitude;
    }

    private static void DFS(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        if (root.left == null && root.right == null) {
            amplitude = Math.max(amplitude, max - min);
            return;
        }

        DFS(root.left, max, min);
        DFS(root.right, max, min);
    }
}
