package DP.DP_game;

/**
 * There are n coins with different value in a line.
 * Two players take turns to take one or two coins from left side until there are no more coins left.
 * The player who take the coins with the most value wins.

 Could you please decide the first player will win or lose?

 Given values array A = [1,2,2], return true.

 Given A = [1,2,4], return false.

 */
public class CoinsinALine2 {


    int[] dp = null;
    boolean[] flag = null;
    int len;

    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values==null || values.length<=2 ){
            return true;
        }

        len = values.length;
        dp = new int[len];
        flag = new boolean[len];

        int sum = 0;
        for(int value : values){
            sum += value;
        }

        dp[0] = goOver(dp,flag,values,0);

        if(dp[0] > sum/2 ){
            return true;
        } else {
            return false;
        }
    }

    public int goOver(int[] dp, boolean[] flag, int[] values, int i){
        if(i>=values.length){
            return 0;
        }

        if(flag[i]){
            return dp[i];
        }

        if(i == len)  {
            dp[i] = 0;
        } else if(i == len-1) {
            dp[i] = values[i];
        } else if(i == len-2) {
            dp[i] = values[i] + values[i + 1];
        } else {
            int tmp = Math.min(goOver(dp,flag,values,i+2),goOver(dp,flag,values,i+3)) + values[i];

            dp[i] = Math.min(goOver(dp,flag,values,i+4),goOver(dp,flag,values,i+3)) + values[i] + values[i+1];

            dp[i] = Math.max(dp[i],tmp);
        }
        flag[i] = true;
        return dp[i];
    }
}
