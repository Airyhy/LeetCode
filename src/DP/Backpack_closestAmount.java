package DP;

public class Backpack_closestAmount {

    public int backPack(int m, int[] caps) {

        int len = caps.length;
        boolean[][] dp = new boolean[len+1][m+1];
        dp[0][0] = true;

        for(int i=0;i<len;i++){
            for(int j=0;j<=m;j++){
                dp[i+1][j] = dp[i][j];
                if(j>=caps[i] && dp[i][j-caps[i]]){
                    dp[i+1][j] = true;
                }
            }
        }

        for(int i=m;i>=0;i--){
            if(dp[len][i]) {
                return i;
            }
        }
        return 0;
    }

}
