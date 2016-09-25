package VFacebookTemp;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesinKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        //DFS to find rest except k
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if(count<k){
            return head;
        }
        curr = reverseKGroup(curr, k);

        //reverse the first k nodes
        while (count > 0) {
            ListNode tmp = head.next;
            head.next = curr;
            curr = head;
            head = tmp;

            count--;
        }
        return curr;
    }

}
