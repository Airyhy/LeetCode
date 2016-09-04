package DP.DP_matrix;

/**
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]

 The total number of unique paths is 2.


 */
public class uniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid==null|| obstacleGrid.length==0 || obstacleGrid[0].length==0){
            return 1;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    grid[i][j] = 0;
                }
                else if(i==0 && j==0){
                    grid[i][j] = 1;
                }
                else if(i==0){
                    grid[i][j] = grid[i][j-1];
                }
                else if(j==0){
                    grid[i][j] = grid[i-1][j];
                }
                else{
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }

}
