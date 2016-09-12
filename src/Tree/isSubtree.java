package Tree;

/**
 * You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 */
public class isSubtree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public  boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true; }
        if (T1 == null) {
            return false;
        }
        return isSameTree(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }else{
            return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }

}
