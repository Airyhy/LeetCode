//find the intersection of two lists
public class LinkedListIntersection{

	
	//sol2: make a circle on one list, then reduce the problem to find the loop head
	// if intersection exists
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;

	    ListNode a = headA;
	    ListNode b = headB;

	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	        //for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }

	    return a;
	}

	//sol1: compute length difference and move pointers on two lists to the same front
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    int lenA = length(headA), lenB = length(headB);
	    // move headA and headB to the same start point
	    while (lenA > lenB) {
	        headA = headA.next;
	        lenA--;
	    }
	    while (lenA < lenB) {
	        headB = headB.next;
	        lenB--;
	    }
	    // find the intersection until end
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    return headA;
	}

	private int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}
}