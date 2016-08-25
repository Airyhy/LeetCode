package DP;

import java.util.ArrayList;


// Given an integer array, adjust each integers so that the difference of every adjacent integers
// are not greater than a given number target.

// If the array before adjustment is A, the array after adjustment is B,
// you should minimize the sum of |A[i]-B[i]|



public class MinAdjustmentCost {
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int len = A.size();
        int[][] dp = new int[len+1][101];
        //initialize
        for(int i=0;i<=len;i++){
            for(int j=0; j<=100; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<=100; i++){
            dp[0][i] = 0;
        }
        //real count
        for(int i=1; i<=len; i++){
            for(int j=0; j<=100; j++){
                for(int k=0; k<=100; k++){
                    if(Math.abs(k-j)<=target){
                        if( dp[i][k] > (dp[i-1][j]+ Math.abs(A.get(i-1)-k))){
                            dp[i][k] = dp[i-1][j] + Math.abs(A.get(i-1)-k);
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=100; i++){
            ans = Math.min(ans,dp[len][i]);
        }
        return ans;
    }
}
