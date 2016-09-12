package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * There is an integer matrix which has the following features:

 The numbers in adjacent positions are different.
 The matrix has n rows and m columns.
 For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
 For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
 We define a position P is a peek if:

 A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
 Find a peak element in this matrix. Return the index of the peak.

 Notice

 The matrix may contains multiple peeks, find any of them.

 Have you met this question in a real interview? Yes
 Example
 Given a matrix:

 [
 [1 ,2 ,3 ,6 ,5],
 [16,41,23,22,6],
 [15,17,24,21,7],
 [14,18,19,20,10],
 [13,14,11,10,9]
 ]
 return index of 41 (which is [1,1]) or index of 24 (which is [2,2])

 */
public class FindPeakElement2 {
    //m+n algorithm, 2D binary search
    // https://segmentfault.com/a/1190000003488794

    //nlogn algorithm it can be updated to have 2 direction binary search for O(n+m) time
    public List<Integer> findPeakII(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        List<Integer> rst = new ArrayList<Integer>();

        int i = 0, j = row-1;
        int mid;
        int maxCol;
        while(i<=j){
            mid = (j-i)/2+i;
            maxCol = maxCol(mid, A);

            if(A[mid][maxCol]<A[mid-1][maxCol]){
                j = mid;
            } else if(A[mid][maxCol]<A[mid+1][maxCol]){
                i = mid;
            } else {
                rst.add(mid);
                rst.add(maxCol);
                break;
            }
        }
        return rst;
    }

    public int maxCol(int mid, int[][] A){
        int maxCol = 0;
        for(int i=0; i<A[0].length; i++){
            if(A[mid][i] > A[mid][maxCol]){
                maxCol = i;
            }
        }
        return maxCol;
    }
}
