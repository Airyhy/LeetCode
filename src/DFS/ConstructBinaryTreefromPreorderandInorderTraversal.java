package DFS;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 ||(preorder.length!=inorder.length)){
            return null;
        }
        return DFS(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }

//    pre 0 134 256
//    ind 314 0 526
    public TreeNode DFS(int ps,int pe, int is, int ie, int[] preorder, int[] inorder){
        if(ps>pe || is>ie) return null;
        int numroot = preorder[ps];
        TreeNode root = new TreeNode(numroot);

        //find the index for 0
        int index = is;
        for(int i=is;i<=ie;i++){
            if(inorder[i]==numroot){
                index = i;
            }
        }

        //get then length
        int leftlen = index-is;

//        count the left part and right part
        root.left = DFS(ps+1,ps+leftlen,is,index-1,preorder,inorder);
        root.right = DFS(ps+leftlen+1,pe,index+1,ie,preorder,inorder);
        return root;

    }
}
