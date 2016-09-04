package LinkedList;

/**
 *
 Given a linked list, return the node where the cycle begins.

 If there is no cycle, return null.
 */
public class LinkedListCycle2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        boolean find = false;

        while( fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                find = true;
                break;
            }
        }

        if(find ==false){
            return null;
        }

        fast = head;
        while(true){
            if(fast==slow) return fast;
            fast = fast.next;
            slow = slow.next;
        }
    }

}
