package LinkedList;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */


public class RemoveDuplicatesfromSortedList2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode deleteDuplicates(ListNode head) {

        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode slow = dum;
        ListNode fast = head;

        while(fast!=null){

            int rec = fast.val;
            while(fast.next!=null && fast.next.val==rec){
                fast = fast.next;
            }

            if(slow.next==fast){
                slow = slow.next;
            }
            else{
                slow.next = fast.next;
            }
            fast = slow.next;
        }
        return dum.next;
    }

}
