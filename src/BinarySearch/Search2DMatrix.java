package BinarySearch;

/**
 * How Many Traget Existing in the Matrix
 */
public class Search2DMatrix {

    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int x = m - 1, y = 0;

        int count = 0;
        while (x >= 0 && y <= n - 1) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }
        return count;
    }


}
