package LinkedList;

/**
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode one = head;
        ListNode two = head;

        while( one!=null && one.next!=null){
            one = one.next.next;
            two = two.next;
            if(one==two){
                return true;
            }
        }
        return false;

    }

}
