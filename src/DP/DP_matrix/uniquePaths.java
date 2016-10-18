package DP.DP_matrix;

/**
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class uniquePaths {


    //O(m * n) O(m * n)
    public int uniquePaths(int m, int n) {
        // write your code here

        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    grid[i][j] = 1;
                }
                else{
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }

    //O(m * n) O(1)
    public int uniquePaths1(int m, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[j] = arr[j] + arr[j-1];
            }
        }
        return arr[m - 1];
    }


    //Best: (m + n - 2)! / ((n - 1)! * (m - 1)!)   C(m - 1, m + n - 2)
    public int uniquePaths2(int m, int n) {
        if( m == 1 || n == 1) {return 1;}
        long result = 1;
        for (int i = 0; i < Math.min(m - 1, n - 1); i++) {
            result = result * (m + n - 2 - i) / (i + 1);
        }
        return (int)result;
    }

}
