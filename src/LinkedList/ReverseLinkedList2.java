package LinkedList;

/**

 Reverse a linked list from position m to n.
 Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.

 */

public class ReverseLinkedList2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode preM = dum;

        for(int i=1;i<m;i++){
            preM = preM.next;
        }

        ListNode mnode = preM.next;
        ListNode nnode = preM.next;
        ListNode postn = nnode.next;

        for(int i=m;i<n;i++){
            ListNode temp = postn.next;

            postn.next = nnode;
            nnode = postn;
            postn = temp;
        }

        preM.next = nnode;
        mnode.next = postn;

        return dum.next;
    }

}
