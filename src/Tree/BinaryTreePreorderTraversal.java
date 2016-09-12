package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
 \
 2
 /
 3

 return [1,2,3].
 */
public class BinaryTreePreorderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode temp = root;
        st.push(root);

        //root -- left -- right
        while(st.empty()==false){
            temp = st.pop();
            if(temp==null) continue;
            result.add(temp.val);
            st.push(temp.right);
            st.push(temp.left);
        }
        return result;
    }

}
