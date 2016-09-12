package DP.DP_interval;

/**
 *
 Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.
 The number in each subarray should be contiguous.

 Return the largest sum.
 Given [-1,4,-2,3,-2,3], k=2, return 8
 */

public class maximumSubarray3 {

    public int maxSubArray(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int len = nums.length;

        //global maximum sum with i subarray until j nums
        int[][] globalMax = new int[k + 1][len + 1];

        //the maximum subarray sum must use i subarray and the jth num
        int[][] localMax = new int[k + 1][len + 1];

        for (int i = 1; i <= k; i++) {
            localMax[i][i-1] = Integer.MIN_VALUE;
            //小于 i 的数组不能够partition
            for (int j = i; j <= len; j++) {

                //add nums[j-1] as a new subarray or to the exsiting subarray
                localMax[i][j] = Math.max(localMax[i][j-1], globalMax[i - 1][j-1]) + nums[j-1];

                if (j == i)
                    globalMax[i][j] = localMax[i][j];
                else
                    globalMax[i][j] = Math.max(globalMax[i][j-1], localMax[i][j]);
            }
        }
        return globalMax[k][len];
    }

}
