package DP.DP_matrix;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class editDistance {

    public int minDistance(String word1, String word2) {
        if(word1==null && word2==null){
            return 0;
        }
        else if(word1==null || word1.length()==0){
            return word2.length();
        }
        else if(word2==null || word2.length()==0){
            return word1.length();
        }

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<len1+1;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<len2+1;i++){
            dp[0][i] = i;
        }

        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if( word1.charAt(i)==word2.charAt(j) ){
                    dp[i+1][j+1] = dp[i][j];
                }
                else{
                    dp[i+1][j+1] = Math.min(dp[i+1][j]+1,dp[i][j+1]+1);
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1],dp[i][j]+1);
                }
            }
        }
        return dp[len1][len2];
    }

}
