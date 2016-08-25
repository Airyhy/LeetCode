/**
* Problem: Find subarray which has the largest sum
*
* Solution 1: dynamic programming--track max_so_far and upate max_end_here
* Solution 2: divide and conquer--max(max left subarray, max right subarray, max subarray crossing midpoint)
*/
public class maximumSubarray{
	public int maxSubArray(int[] A){
		if(A==null || A.length==0){
			return 0;
		}
		int len = A.length;
		int max_ending_here = A[0];
		int max_so_far = A[0];
		for(int i=1; i<len; i++){
			max_ending_here = Math.max(A[i], max_ending_here+A[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		return max_so_far;
	}
}
