package DP.DP_interval;



import java.util.ArrayList;


/**
 *
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 */
public class maximumSubarray {


    //maximum subarray

    public int maxSubArray(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int sum = nums[0];
        dp[0] = nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            sum = Math.max(sum,dp[i]);
        }

        return sum;
    }

}
