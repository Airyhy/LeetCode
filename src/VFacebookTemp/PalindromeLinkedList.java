package VFacebookTemp;

/**
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode tail = head;
        ListNode mid = head;

        while(tail!=null && tail.next!=null){
            mid = mid.next;
            tail = tail.next.next;
        }

        //odd number, need to come to right part
        if(tail!=null) mid = mid.next;
        tail = reverse(mid);

        //Palimdrome comparison
        while(tail!=null){
            if(tail.val!=head.val){
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        return true;

    }

    //Very important
    public ListNode reverse(ListNode mid){
        ListNode pre = null;
        ListNode cur = mid;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
