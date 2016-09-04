package DP.DP_game;


/**
 Given n distinct positive integers, integer k (k <= n) and a number target.

 Find k numbers where sum is target. Calculate how many solutions there are?

 Given [1,2,3,4], k = 2, target = 5.

 There are 2 solutions: [1,4] and [2,3].
 */
public class KSum {
    public int kSum(int A[], int k, int target) {
        // write your code here
        int len = A.length;
        int[][][] dp = new int[len+1][k+1][target+1];
        for(int i=0;i<len+1;i++){
            dp[i][0][0] = 1;
        }

        for(int i=1; i<len+1; i++){
            for(int j=1; j<k+1; j++){
                for(int m=1; m<target+1; m++){
                    if(m>=A[i-1]){
                        dp[i][j][m] = dp[i-1][j-1][m-A[i-1]];
                    }
                    dp[i][j][m] += dp[i - 1][j][m];
                }
            }
        }

        return dp[len][k][target];
    }
}
