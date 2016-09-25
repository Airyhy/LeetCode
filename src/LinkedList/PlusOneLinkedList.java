package LinkedList;

/**

 Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4

 */
public class PlusOneLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * DFS
     */
    public ListNode plusOne(ListNode head) {
        if(DFS(head)==0){
            return head;
        }

        ListNode dum = new ListNode(1);
        dum.next = head;
        return dum;
    }

    /**
     * Add one from the last node
     */
    public int DFS(ListNode head){
        if(head==null) {
            return 1;
        }

        if(DFS(head.next)==0) {
            return 0;
        }

        int newval = head.val + 1;
        head.val = newval%10;
        return newval/10;
    }

}
