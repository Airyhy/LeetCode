package DP.DP_matrix;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class minimumPathSum {

    public int minPathSum(int[][] grid) {

        if(grid==null || grid.length ==0 || grid[0].length==0){
            return 0;
        }
        int row = grid.length;
        int colo = grid[0].length;

        //pre-compute the content
        for(int j=1;j<colo;j++){
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }

        for(int i=1;i<row;i++){
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }

        //iterate to get the sum
        for(int i=1;i<row;i++){
            for(int j=1;j<colo;j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[row-1][colo-1];
    }

}
