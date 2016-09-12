package Matrix;


public class rotateMatrix {

    /**
     * 一道rotate m*n matrix，没有很难，跟leetcode rotate image差不多，只不过是m*n而已,可以参见
     * leetcode https://leetcode.com/problems/rotate-image/，
     * 不过不一样的是1.不是正方形的 2.给一个flag参数用来决定是往左还是往右。如果之前的算法不是in space的话应该没有啥差别。

     */


    public static int[][] rotate3(int[][] matrix, int flag){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || flag>1 || flag<0 ){
            return matrix;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] newM = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                newM[i][j] = flag == 0? matrix[m-1-j][i] : matrix[j][n-1-i];
            }
        }
        return newM;
    }

    /**
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Follow up:
    Could you do this in-place?
     */

    public void rotate(int[][] matrix) {
        if(matrix==null) return;
        int m = matrix.length;

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j){
                    continue;
                }
                else if(i>j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        System.out.println(matrix[m-1][m-1]);
        for(int i=0;i<m;i++){
            for(int j=0;j<m/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-1-j];
                matrix[i][m-1-j] = temp;
            }
        }
        return;
    }

}
