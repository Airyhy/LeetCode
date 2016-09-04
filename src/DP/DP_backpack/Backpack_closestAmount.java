package DP.DP_backpack;


/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

 You can not divide any item into small pieces.

 Example
 If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5],
 so that the max size we can fill this backpack is 10. If the backpack size is 12.
 we can select [2, 3, 7] so that we can fulfill the backpack.

 You function should return the max size we can fill in the given backpack.
 */
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
