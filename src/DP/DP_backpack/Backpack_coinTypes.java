package DP.DP_backpack;

/**
 * 给1,2,5,10硬币无数多个,请问凑80元的方案总数
 */

public class Backpack_coinTypes {

    public int backPack(int m, int[] caps) {

        int len = caps.length;
        int[][] DP = new int[len+1][m+1];
        for(int i = 0; i <= len; ++i){
            DP[i][0] = 1;
        }

        for(int i = 1; i <= len; ++i) {
            for(int j = 0; j <= m; ++j) {
                int add = 0;
                if(j>=caps[i-1]){
                    add = DP[i][j-caps[i-1]];
                }
                DP[i][j] = DP[i-1][j] + add;
            }
        }

        return DP[len][m];
    }
}
