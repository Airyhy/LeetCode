package Matrix;

/**
 * 给一个int[][]的matirx，对于一条从左上到右下的path p_i，p_i中的最小值是m_i，求所有m_i中的最大值。只能往下或右.
 比如：
 [8, 4, 7]
 [6, 5, 9].

 有3条path：.
 8-4-7-9 min: 4.
 8-4-5-9 min: 4
 8-6-5-9 min: 5.
 return: 5.
 */
public class MaxMinPathinMatrix {

    static int m, n, max;
    public static int maximumMinimumPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }
        m = matrix.length;
        n = matrix[0].length;
        max = Integer.MIN_VALUE;

        DFS(matrix, 0, 0, matrix[0][0]);
        return max;
    }

    private static void DFS(int[][] matrix, int i, int j, int currentMin) {
        if (i >= m || j >= n) {
            return;
        }

        currentMin = Math.min(currentMin, matrix[i][j]);
        if (i == m - 1 && j == n - 1) {
            max = Math.max(max, currentMin);
            return;
        }
        DFS(matrix, i + 1, j, currentMin);
        DFS(matrix, i, j + 1, currentMin);
    }
}
