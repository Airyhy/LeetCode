package DP.DP_backpack;

/**
 * Given n items with size Ai and value Vi, and a backpack with size m.
 * What's the maximum value can you put into the backpack?

 Notice

 You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

 Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
 */
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
