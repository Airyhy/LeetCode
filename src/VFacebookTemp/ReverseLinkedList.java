package VFacebookTemp;

/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode reverseList(ListNode head) {
            if(head==null) return null;

            ListNode cur = head;
            ListNode prev = null;
            while(cur!=null){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            return prev;

        }
    }
}
