package DP.DP_matrix;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0.
 */
public class maximalSquare {

    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }

        int row = matrix.length, col = matrix[0].length;
        int[][] val = new int[row][col];
        int area = 0;

        for(int i=0; i<row ;i++){
            for(int j=0; j<col ;j++){
                if(matrix[i][j]==1){
                    val[i][j]=1;
                    area = 1;
                }
            }
        }

        for(int i=1; i<row ;i++){
            for(int j=1; j<col ;j++){
                if(matrix[i][j]==1){
                    int lenCo = val[i-1][j-1];
                    int lenEd = Math.min(val[i-1][j],val[i][j-1]);
                    val[i][j] = Math.min(lenCo,lenEd)+1;

                    area = Math.max(area,val[i][j]*val[i][j]);
                }
            }
        }

        return area;
    }

}
