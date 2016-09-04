package DP.DP_interval;

import java.util.ArrayList;

/**
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 The number in each subarray should be contiguous.
 Return the largest sum.

 Example
 For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2],
 they both have the largest sum 7.
 */

public class maximumContinuousSubarraySum2 {

    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = nums.get(0);
        int now = nums.get(0);

        for(int i = 1; i < size; i++){
            now = Math.max(now+nums.get(i),nums.get(i));
            left[i] = Math.max(left[i-1],now);

        }

        right[size-1] = nums.get(size-1);
        now = nums.get(size-1);

        for(int i = size - 2; i >= 0; i--){
            now = Math.max(now+nums.get(i),nums.get(i));
            right[i] = Math.max(right[i+1],now);

        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}
