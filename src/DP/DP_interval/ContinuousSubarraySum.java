package DP.DP_interval;

import java.util.ArrayList;

/**
 * Given an integer array, find a continuous subarray where the sum of numbers is the biggest.
 * Your code should return the index of the first number and the index of the last number.
 * (If their are duplicate answer, return anyone)

 Have you met this question in a real interview? Yes
 Example
 Give [-3, 1, 3, -3, 4], return [1,4].
 */
public class ContinuousSubarraySum {



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

}
