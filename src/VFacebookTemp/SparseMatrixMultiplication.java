package VFacebookTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                   | 0 0 1 |
 */
public class SparseMatrixMultiplication {

    //NAIVE IDEAD
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }

    //SPARSE IDEA
    public int[][] multiply2(int[][] A, int[][] B) {
        if (A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0) {return new int[][]{};}
        int m = A.length, n = B.length, d = B[0].length;
        int[][] ret = new int[m][d];

        //find all non-0 element
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    temp.put(j, A[i][j]);
                }
            }
            map.put(i, temp);
        }

        //add the element sum to match the resule
        for (int key1 : map.keySet()) {
            for (int key2 : map.get(key1).keySet()) {
                for (int i = 0; i < d; i++) {
                    if(B[key2][i]!=0){
                        ret[key1][i] += map.get(key1).get(key2) * B[key2][i];
                    }
                }
            }
        }
        return ret;
    }

}
