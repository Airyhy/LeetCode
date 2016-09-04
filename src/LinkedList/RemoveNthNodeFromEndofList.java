package LinkedList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.

 */
public class RemoveNthNodeFromEndofList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    //Method 1: two pointers, with distance n
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    //Method2: tranverse for length, then count again
    ListNode removeNthFromEnd2(ListNode head, int n) {
        // write your code here
        ListNode dum = new ListNode(-1);
        dum.next = head;

        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }

        head = dum;
        for(int i=0;i<count-n;i++){
            head = head.next;
        }

        head.next = head.next.next;
        return dum.next;
    }
}
