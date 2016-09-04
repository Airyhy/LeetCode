package DP.DP_game;

/**
 * There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

 The goal is to merge the stones in one pile observing the following rules:

 At each step of the game,the player can merge two adjacent piles to a new pile.
 The score is the number of stones in the new pile.
 You are to determine the minimum of the total score.

 For [4, 1, 1, 4], in the best solution, the total score is 18:

 1. Merge second and third piles => [4, 2, 4], score +2
 2. Merge the first two piles => [6, 4]，score +6
 3. Merge the last two piles => [10], score +10
 Other two examples:
 [1, 1, 1, 1] return 8
 [4, 4, 5, 9] return 43
 */
public class stoneGame {

    int[][] dp;
    int[][] sum;
    boolean[][] flag;

    public int stoneGame(int[] A) {
        // Write your code here
        if(A==null || A.length==0){
            return 0;
        }
        int len = A.length;
        dp = new int[len][len];
        sum = new int[len][len];
        flag = new boolean[len][len];

        //The sum from j to i
        for(int i=0;i<len;i++){
            sum[i][i] = A[i];
            for(int j=i-1;j>=0;j--){
                sum[j][i] = sum[j+1][i] + A[j];
            }
        }

        for(int i=0;i<len;i++){
            dp[i][i] = 0;
            flag[i][i] = true;
        }

        return search(0,len-1);
    }

    public int search(int j, int i){
        if(flag[j][i]){
            return dp[j][i];
        }
        int tmp = Integer.MAX_VALUE;
        for(int k=j;k<i;k++){
            tmp = Math.min(search(j,k)+search(k+1,i)+ sum[j][i],tmp);
        }

        flag[j][i] = true;
        dp[j][i] = tmp ;
        return dp[j][i];
    }
}
