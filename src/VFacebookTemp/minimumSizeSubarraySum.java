package VFacebookTemp;

/**
 Given an array of n positive integers and a positive integer s,
 find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

 Have you met this question in a real interview? Yes
 Example
 Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

 */
public class minimumSizeSubarraySum {

    public int minimumSize(int[] nums, int s) {
        // write your code here
        if( nums==null || nums.length==0 ){
            return -1;
        }

        //创造一个window,一边+,一边-.莤barray

        int j = 0, sum = 0, min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            while( j<nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            if( sum >= s){
                min = Math.min(min, j-i);
            }
            sum -= nums[i];
        }

        if( min== Integer.MAX_VALUE){
            return -1;
        } else {
            return min;
        }
    }

}
