package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 */
public class BinaryTreePostorderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * Recursive
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        result.addAll(postorderTraversal(root.left));

        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    /**
     * Iterate
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode temp = root;
        st.push(root);

        //root - right - left
        while(st.empty()==false){
            temp = st.pop();
            if(temp==null) continue;
            result.add(temp.val);
            st.push(temp.left);
            st.push(temp.right);
        }

        //left - right -root
        Collections.reverse(result);
        return result;
    }

}
