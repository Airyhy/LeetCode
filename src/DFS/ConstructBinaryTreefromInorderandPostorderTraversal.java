package DFS;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0 ||(postorder.length!=inorder.length)){
            return null;
        }
        return DFS(0,postorder.length-1,0,inorder.length-1,postorder,inorder);
    }

    //    pos 341 562 0
    //    ind 314 0 526
    public TreeNode DFS(int ps,int pe, int is, int ie, int[] postorder, int[] inorder){
        if(ps>pe || is>ie) return null;
        int numroot = postorder[pe];
        TreeNode root = new TreeNode(numroot);

        int index = is;
        for(int i=is;i<=ie;i++){
            if(inorder[i]==numroot){
                index = i;
            }
        }
        int rightlen = ie-index;
        root.left = DFS(ps,pe-rightlen-1,is,index-1,postorder,inorder);
        root.right = DFS(pe-rightlen,pe-1,index+1,ie,postorder,inorder);
        return root;

    }
}
