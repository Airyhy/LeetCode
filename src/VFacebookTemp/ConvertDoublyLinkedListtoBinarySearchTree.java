package VFacebookTemp;

import java.util.Stack;

public class ConvertDoublyLinkedListtoBinarySearchTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }



    /**
     * Convert Doubly Linked List to Binary Search Tree
     */

    TreeNode GetBST(DoublyListNode head, DoublyListNode tail)
    {
        DoublyListNode median = GetMedian(head, tail);
        TreeNode root = new TreeNode(median.val);

        if(median!=head){
            DoublyListNode left_head = head, left_tail = median.prev;
            root.left = GetBST(left_head, left_tail);
        }

        if(median!=tail){
            DoublyListNode right_head = median.next, right_tail = tail;
            root.right = GetBST(right_head, right_tail);
        }

        return root;

    }


    DoublyListNode GetMedian(DoublyListNode first, DoublyListNode last)
    {
        if(first==last)
            return first;

        DoublyListNode fast = first, slow = first;

        while(fast!=last && fast.next!=last)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    /**
     * convert binary search tree to doubly linked list
     */

    class ResultType {
        DoublyListNode first, last;

        public ResultType(DoublyListNode first, DoublyListNode last) {
            this.first = first;
            this.last = last;
        }
    }

    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        ResultType result = helper(root);
        return result.first;
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);

        ResultType result = new ResultType(null, null);

        if (left == null) {
            result.first = node;
        } else {
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }

        if (right == null) {
            result.last = node;
        } else {
            result.last = right.last;
            right.first.prev = node;
            node.next = right.first;
        }

        return result;
    }



    //stack
    public DoublyLinkedList convert(TreeNode root) {
        if (root == null) {return null;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }

        DoublyLinkedList head = new DoublyLinkedList(stack.pop().val);
        DoublyLinkedList tail = head;
        if (root.left != null) {stack.push(root.left);}

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            tail.next = new DoublyLinkedList(node.val);
            tail.next.pre = tail;
            tail = tail.next;

            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        head.pre = tail;
        tail.next = head;
        return head;
    }




    /**
     * convert binary search tree to doubly linked list
     */
    public TreeNode bstToDoublyList2(TreeNode root) {
        if (root == null) {return root;}
        TreeNode[] convert = convert2Helper(root);
        convert[0].left = convert[1];
        convert[1].right = convert[0];
        return convert[0];
    }

    public TreeNode[] convert2Helper(TreeNode root) {
        TreeNode[] left = root.left == null ? null : convert2Helper(root.left);
        TreeNode[] right = root.right == null ? null : convert2Helper(root.right);

        TreeNode head = left == null ? root : left[0];
        TreeNode tail = right == null ? root : right[1];

        if (left != null) {
            left[1].right = root;
            root.left = left[1];
        }
        if (right != null) {
            right[0].left = root;
            root.right = right[0];
        }
        return new TreeNode[]{head, tail};
    }



    public static class DoublyLinkedList {
        int val;
        DoublyLinkedList pre;
        DoublyLinkedList next;

        public DoublyLinkedList(int val) {
            this.val = val;
        }

    }
}
