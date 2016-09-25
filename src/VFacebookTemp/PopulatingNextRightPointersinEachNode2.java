package VFacebookTemp;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
   1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
    1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
 4->5 -> 7 -> NULL
 */

public class PopulatingNextRightPointersinEachNode2 {


    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }


    public void connect(TreeLinkNode root) {
        if(root==null) return ;
        Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();

        que.add(root);

        while(que.isEmpty() == false){
            int count = que.size();
            int len = que.size();

            for(int i=0 ; i<len ; i++){
                TreeLinkNode node = que.poll();
                if(count>1){
                    node.next = que.peek();
                }
                count--;

                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null ){
                    que.add(node.right);
                }
            }
        }
        return;
    }

}
