package DP.DP_seuqence;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101],
 therefore the length is 4. Note that there may be more than one LIS combination,
 it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.
 */
public class LongestIncreasingSubsequence {

    /**
     *  O(n^2) compare each to its all previous one
    */

    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);


        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            // System.out.println(dp[i]);
        }

        int max = dp[0];
        for(int j: dp){
            max = Math.max(max,j);
        }
        return max;
    }


    /** O(nlogn) Work like a wave, each time, only focus on one wave length,
     * search the insertion position to the previous wave
    */

    public int lengthOfLIS2(int[] nums) {
        int[] minLast = new int[nums.length];

        //create an array with Max, when search, will insert into best position
        for (int i = 0; i < nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {

            // find the first number in minLast > nums[i], to insert
            int index = Arrays.binarySearch(minLast, 0, minLast.length, nums[i]);

            // if all larger, insert to insertion position, usually 0
            if(index < 0) {
                index = -(index+1);
            }

            minLast[index] = nums[i];
        }

        for (int i = nums.length-1; i >= 0; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i+1;
            }
        }

        return 0;
    }

}
