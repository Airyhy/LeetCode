package VFacebookTemp;

import java.util.Stack;

/**

 Given a 2D binary matrix filled with 0's and 1's,
 find the largest rectangle containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 6.

 */

public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1) return 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[][] height = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0)
                    height[i][j] = ((matrix[i][j] == '1') ? 1 : 0);
                else
                    height[i][j] += ((matrix[i][j] == '1') ? height[i-1][j] + 1 : 0);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; ++i) {
            Stack<Integer> S = new Stack<Integer>();
            for (int j = 0; j <= m; j++) {
                int cur = -1;

                if(j <m) {
                    cur = height[i][j];
                }

                while (!S.empty() &&  cur <= height[i][S.peek()]) {
                    int pos = S.peek();
                    S.pop();
                    answer = Math.max(answer, height[i][pos]*(S.empty()? j : j-S.peek()-1));
                }
                S.push(j);
            }
        }
        return answer;
    }

}
