package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }

 Populate each next pointer to point to its next right node.
 If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
  1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode {


    public class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if(root==null || root.left==null){
            return;
        }

        connectnode(root.left,root.right);
        return;
    }

    public void connectnode(TreeLinkNode node1, TreeLinkNode node2){
        node1.next = node2;
        if(node1.left!=null){
            connectnode(node1.left,node1.right);
            connectnode(node2.left,node2.right);
            connectnode(node1.right,node2.left);
        }
    }

    //BFS iterate
    public void connect2(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeLinkNode temp = que.poll();
                if (temp.left != null) que.add(temp.left);
                if (temp.right != null) que.add(temp.right);
                temp.next = size == 0 ? null : que.peek();
            }
        }
    }
}
