package DP.DP_game;

/**
 * There are n coins in a line.
 * Two players take turns to take a coin from one of the ends of the line until there are no more coins left.
 * The player with the larger amount of money wins.

 Could you please decide the first player will win or lose?

 Given array A = [3,2,2], return true.

 Given array A = [1,2,4], return true.

 Given array A = [1,20,4], return false.
 */
public class CoinsinALine3 {

    int dp[][] = null;
    boolean flag[][] = null;

    public boolean firstWillWin(int[] values) {
        if(values==null || values.length<3){
            return true;
        }

        //2 Dimension DP
        int len = values.length;
        dp = new int[len][len];
        flag = new boolean[len][len];

        int sum = 0;
        for(int i=0; i< len ;i++){
            sum += values[i];
            dp[i][i] = values[i];
            flag[i][i] = true;
        }

        dp[0][len-1] = goOver(values,0,len-1);
        if(dp[0][len-1] > sum/2){
            return true;
        } else {
            return false;
        }
    }

    public int goOver( int[] values, int i, int j){
        if(i>j) return 0;

        if(flag[i][j]) return dp[i][j];

        dp[i][j] = Math.min(goOver(values,i+2,j),goOver(values,i+1,j-1)) + values[i];
        int tmp = Math.min(goOver(values,i,j-2),goOver(values,i+1,j-1)) + values[j];
        dp[i][j] = Math.max(dp[i][j],tmp);
        flag[i][j] = true;

        return dp[i][j];
    }
}
