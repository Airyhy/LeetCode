//merge k sorted list

//sol1: use merge sort, time O(nklogk), stack space O(logk)
//sol2: use heap(priority queue), time O(nklogk), space O(k)

import java.util.*;
public class mergeSortedLists{

	public ListNode mergeKLists(ListNode[] lists) {
	    // public ListNode mergeKLists(List<ListNode> lists) {  
	        // write your code here
	        if(lists==null || lists.length==0){
	            return null;
	        }
	        return binarymerge(lists,0,lists.length-1);
	    }
	    public ListNode binarymerge(ListNode[] lists,int lo, int hi){
	        if(lo>=hi) { 
	            return lists[lo];
	        }
	        int mid = (hi-lo)/2 + lo;
	        ListNode left = binarymerge(lists,lo, mid);
	        ListNode right = binarymerge(lists,mid+1,hi);
	        return merge(left,right);
	        
	    }
	    public ListNode merge(ListNode a, ListNode b){
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


	public ListNode mergeKLists2(ArrayList<ListNode> lists){
		if(lists==null || lists.size()==0){
			return null;
		}
		int k = lists.size();
		//create priority with node comparator
		PriorityQueue<ListNode> q 
		        = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
		        	public int compare(ListNode n1, ListNode n2){
		        		return n1.val - n2.val;
		        	}
		        });

		//put initial elements
		//time O(k)
		for(int i=0; i<k; i++){
			if(lists.get(i)!=null){
				q.offer(lists.get(i));
			}
		}


        ListNode res = null;
        ListNode resCurr = null;
        //time O(nklogk)
		while(!q.isEmpty()){
			ListNode n = q.poll();
			if(res == null){
				res = n;
				resCurr = res;
			}else{
				resCurr.next = n;
				resCurr = resCurr.next;
			}
			//put next element in the list if possible
			if(n.next !=null){
				q.offer(n.next);
			}
		}
		return res;
	}
}