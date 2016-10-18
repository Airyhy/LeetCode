package DP.DP_interval;

/**
 *给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 */

public class longestCommonSubsequence {

    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A==null || B==null ||A.length()==0 || B.length()==0)
            return 0;

        int[][] dp = new int[A.length()+1][B.length()+1];

        for(int i=0;i<A.length()+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<B.length()+1;j++){
            dp[0][j] = 0;
        }

        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                if(A.charAt(i)!=B.charAt(j)){
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j]+1);
                }

            }
        }
        return dp[A.length()][B.length()];
    }
}
