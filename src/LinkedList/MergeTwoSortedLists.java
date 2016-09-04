package LinkedList;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a==null) return b;
        if(b==null) return a;

        ListNode head = new ListNode(-1);
        ListNode index = head;
        while(a!=null || b!=null){
            if(a==null){
                index.next = b;
                break;
            }
            else if(b==null){
                index.next = a;
                break;
            }
            else if(a.val>b.val){
                index.next = b;
                index = index.next;
                b = b.next;
            }else{
                index.next = a;
                index = index.next;
                a = a.next;
            }
        }
        return head.next;
    }

}
