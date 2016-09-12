package DFS;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.

 Subscribe to see which companies asked this question
 */
public class ConvertSortedListtoBinarySearchTree {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev =null;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            prev =slow;
            slow=slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        prev.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }


    //In the form of Array
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        int len = nums.length-1;
        TreeNode root = DFS(nums,0,len);
        return root;
    }

    public TreeNode DFS(int[] nums, int low, int high){
        if(low>high) return null;
        else if(low==high) {
            return new TreeNode(nums[low]);
        }
        int mid = (high-low)/2 + low;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = DFS(nums,low,mid-1);
        root.right = DFS(nums,mid+1,high);

        return root;
    }
}
