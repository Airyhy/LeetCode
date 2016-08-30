package Stack;

import java.util.Stack;

/**
 * Given an integer array with no duplicates. A max tree building on this array is defined as follow:

 The root is the maximum number in the array
 The left subtree and right subtree are the max trees of the subarray divided by the root number.
 Construct the max tree by the given array.

 Have you met this question in a real interview? Yes
 Example
 Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:

     6
    / \
    5   3
    /   / \
    2   0   1
 */
public class maxTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    //维持一个递减栈
    public TreeNode maxTree(int[] A) {
        // write your code here
        if(A==null || A.length==0){
            return null;
        }

        Stack<TreeNode> st = new Stack<TreeNode>();

        for(int i=0;i<A.length ;i++){
            TreeNode temp = new TreeNode(A[i]);
            while(st.isEmpty()==false && temp.val>st.peek().val){
                temp.left = st.pop();
            }
            if(st.isEmpty()==false){
                st.peek().right = temp;
            }
            st.push(temp);
        }

        while(st.size()!=1){
            st.pop();
        }
        return st.pop();

    }

}
