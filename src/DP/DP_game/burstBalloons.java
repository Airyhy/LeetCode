package DP.DP_game;

import java.util.Arrays;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 *
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.
 - You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 - 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 Example
 Given [4, 1, 5, 10]
 Return 270

 nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
 nums = [4, 5, 10]    burst 5, get coins 4 * 5 * 10 = 200
 nums = [4, 10]       burst 4, get coins 1 * 4 * 10 = 40
 nums = [10]          burst 10, get coins 1 * 10 * 1 = 10

 Total coins 20 + 200 + 40 + 10 = 270
 */
public class burstBalloons {

    int[][] dp;
    boolean[][] flag;
    int[] pro;
    public int maxCoins(int[] nums) {
        // Write your code here
        if(nums==null || nums.length==0){
            return 0;
        }

        int len = nums.length;
        dp = new int[len+2][len+2];
        flag = new boolean[len+2][len+2];
        pro = new int[len+2];

        //resize array to len+2 size
        Arrays.fill(pro,1);
        for(int i=1;i<=len;i++){
            pro[i] = nums[i-1];
        }

        return search(1,len);
    }

    public int search(int lo, int hi){
        if(lo>hi) { return 0; }

        if(flag[lo][hi]){
            return dp[lo][hi];
        }

        int tmp = 0;
        for(int k=lo;k<=hi;k++){
            tmp = Math.max(tmp,pro[k]*pro[lo-1]*pro[hi+1]+
                    search(lo,k-1)+search(k+1,hi));
        }
        flag[lo][hi] = true;
        dp[lo][hi] = tmp;

        return tmp;
    }
}
