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

    //O(n), O(1)
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

    //recursive
    //O(n), 0(n)
    public ListNode reverseList1(ListNode head) {
        return reverseListInt(head, null);
    }

    public ListNode reverseListInt(ListNode head, ListNode newHead) {
        if(head == null) {return newHead;}
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
