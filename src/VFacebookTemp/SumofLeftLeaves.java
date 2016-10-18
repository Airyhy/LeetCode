package VFacebookTemp;

/**
 Find the sum of all left leaves in a given binary tree.

 Example:

 3
 / \
 9  20
    /  \
   15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumofLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int count = 0;


    public int sumOfLeftLeaves(TreeNode root) {
        if(root != null ){
            countLeft(root,false);
        }
        return count;
    }

    public void countLeft(TreeNode root, boolean isLeft){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null && isLeft){
            count += root.val;
        }

        countLeft(root.left,true);
        countLeft(root.right,false);
    }

}
