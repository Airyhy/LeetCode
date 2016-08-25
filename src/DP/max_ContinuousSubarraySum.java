package DP;


//maximum continuous subarray

import java.util.ArrayList;

public class max_ContinuousSubarraySum {

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

//      Given an integer array, find a continuous subarray where the sum of numbers is the biggest.
//      Your code should return the index of the first number and the index of the last number.
//      (If their are duplicate answer, return anyone)



    //return the index of the subarray
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);

        int len = A.length;
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < len; ++i) {
            if (sum < 0) {
                sum = A[i];
                start = end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if (sum >= ans) {
                ans = sum;
                result.set(0, start);
                result.set(1, end);
            }
        }
        return result;
    }

//   Given an circular integer array
//   (the next element of the last element is the first element), find a continuous subarray in it,
//   where the sum of numbers is the biggest.
//   Your code should return the index of the first number and the index of the last number.
//   If duplicate answers exist, return any of them.

    //the array can be counted as round
    // find the maximum subarray in the middle
    // find the minimum subarray in the middle
    // do the minus and total to compare the larger one
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);
        int total = 0;
        int len = A.length;
        int start = 0, end = 0;
        int local = 0;
        int global = -0x7fffffff;
        for (int i = 0; i < len; ++i) {
            total += A[i];
            if (local < 0) {
                local = A[i];
                start = end = i;
            } else {
                local += A[i];
                end = i;
            }
            if (local >= global) {
                global = local;
                result.set(0, start);
                result.set(1, end);
            }
        }

        local = 0;
        start = 0;
        end = -1;

        for (int i = 0; i < len; ++i) {
            if (local > 0) {
                local = A[i];
                start = end = i;
            } else {
                local += A[i];
                end = i;
            }
            if (start == 0 && end == len-1) continue;
            if (total - local >= global) {
                global = total - local;
                result.set(0, (end + 1) % len);
                result.set(1, (start - 1 + len) % len);
            }
        }
        return result;
    }
}
