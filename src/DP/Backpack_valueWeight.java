package DP;

public class Backpack_valueWeight {

    public int backPackII(int m, int[] A, int V[]) {
        int len = A.length;
        if(len<=0) return 0;
        int[][] dp = new int[len+1][m+1];

        for(int i=0; i<len; i++){
            for(int j=0; j<=m; j++){
                dp[i+1][j] = dp[i][j];
                if(j>=A[i]){
                    dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j-A[i]]+V[i]);
                }
            }
        }

        return dp[len][m];
    }


    public int backPackII2(int m, int[] A, int V[]) {
        // write your code here
        int[] f = new int[m+1];
        for (int i = 0; i <=m ; ++i) f[i] = 0;
        int n = A.length , i, j;
        for(i = 0; i < n; i++){
            for(j = m; j >= A[i]; j--){
                if (f[j] < f[j - A[i]] + V[i])
                    f[j] = f[j - A[i]] + V[i];
            }
        }
        return f[m];
    }
}
