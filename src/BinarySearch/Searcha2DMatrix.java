package BinarySearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }

        int nrow = matrix.length, ncol = matrix[0].length;
        int low =0, high = nrow*ncol - 1;

        while(low+1<high){
            int mid = (high-low)/2 + low;
            int temp = matrix[mid/ncol][mid%ncol];

            if(temp<target){
                low = mid;
            }
            else if(temp>target){
                high = mid;
            }
            else{
                return true;
            }
        }

        if(matrix[high/ncol][high%ncol]==target ||matrix[low/ncol][low%ncol]==target ) {
            return true;
        }

        return false;
    }
}
