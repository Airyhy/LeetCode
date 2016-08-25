//http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/

//use bubble sort O(nk)
//use sort O(nlogn)
//use max heap(build O(n) and extra max k times O(klogn)) time O(n+klogn)
//quick select


import java.util.*;
public class kLargestElements{
	public static void main(String[] args){
		int[] test = new int[]{7,5,2,4,3,9};
		int res = findKLargest3(test,3);
		System.out.println(res);
	}

    
    //use priority queue
    //time O(n+klogn)
	public static int findKLargest2(int[] array, int k){
		if(array == null){
			return Integer.MAX_VALUE;
		}
		int len = array.length;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(len, new Comparator<Integer>(){
			public int compare(Integer n1, Integer n2){
				return n2 - n1;
			}
		});
		for(int num: array){
			pq.offer(num);
		}
		int[] res = new int[k];
		for(int i=0; i<k; i++){
			res[i] = pq.poll();
		}
		return res[k-1];

	}

	//quicksort
	//worst O(n^2) averageO(n)
	public class Solution {
	    public int findKthLargest(int[] nums, int k) {
	        int start = 0, end = nums.length -1, dest = nums.length -k;
	        while(start<end){
	            int pivot = partion(nums,start,end);
	            if(pivot>dest){
	                end = pivot -1;
	            }
	            else if(pivot<dest){
	                start = pivot + 1;
	            }
	            else{
	                return nums[pivot];
	            }
	        }
	        return nums[dest];
	    }
	    
	    public int partion(int[] nums, int start, int end){
	        int re = start;
	        //System.out.println(nums[1]);
	          
	        while(start<end){
	            while(start<=end && nums[start]<=nums[re]) start++;
	            
	            while(start<=end && nums[end]>=nums[re]) end--;
	            if(start<end){
	                int temp = nums[end];
	                nums[end] = nums[start];
	                nums[start] = temp;
	            }
	        }
	        int temp1 = nums[re];
	        nums[re] = nums[end];
	        nums[end] = temp1;
	        
	       // System.out.println(nums[1]);
	    //    System.out.println(end);
	        return end;
	    }
	}
}
