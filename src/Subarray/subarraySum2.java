package Subarray;


import java.util.HashMap;
import java.util.Map;

public class subarraySum2 {


    public int[][] submatrixSum(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rst = new int[2][2];
        int[][] sum = new int[row+1][col+1];

        //pre - compute for the upper left sum
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
        }

        //iterate through all the differences, find diff
        for(int i=0; i<row; i++){
            for(int j=i+1; j<=row; j++){
                Map<Integer,Integer> map = new HashMap<>();
                for(int m=0; m<=col; m++){
                    int diff = sum[j][m]-sum[i][m];
                    if(map.containsKey(diff)){
                        int k = map.get(diff);

                        //return the original coordinate
                        rst[0][0] = i;
                        rst[0][1] = k;
                        rst[1][0] = j-1;
                        rst[1][1] = m-1;
                        return rst;
                    }
                    map.put(diff,m);
                }
            }
        }
        return rst;
    }

}
