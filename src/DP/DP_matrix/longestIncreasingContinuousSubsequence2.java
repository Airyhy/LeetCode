package DP.DP_matrix;

import java.util.Arrays;

/**
 * Give you an integer matrix (with row size n, column size m)，
 * find the longest increasing continuous subsequence in this matrix.
 *
 * (The definition of the longest increasing continuous subsequence here can
 * start at any row or column and go up/down/right/left any direction).

 Have you met this question in a real interview? Yes
 Example
 Given a matrix:

 [
 [1 ,2 ,3 ,4 ,5],
 [16,17,24,23,6],
 [15,18,25,22,7],
 [14,19,20,21,8],
 [13,12,11,10,9]
 ]
 return 25
 */
public class longestIncreasingContinuousSubsequence2 {

    boolean[][] flag ;
    int[][] dp ;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if(A==null || A.length==0 || A[0]==null || A[0].length==0 ){
            return 0;
        }

        int row = A.length;
        int col = A[0].length;
        flag = new boolean[row][col];
        dp = new int[row][col];

        for(int[] entry : dp){
            Arrays.fill(entry,1);
        }

        int max = 1;

        for(int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                max = Math.max(max,search(i,j,A));
            }
        }

        return max;
    }

    public int search(int x, int y, int[][] A){

        if(flag[x][y]){
            return dp[x][y];
        }

        for(int i=0;i<dx.length;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if( nx>=0 && nx<A.length && ny>=0 && ny<A[0].length && A[x][y]>A[nx][ny]){
                dp[x][y] = Math.max(search(nx,ny,A)+1,dp[x][y]);
            }
        }

        flag[x][y] = true;
        return dp[x][y];
    }
}
