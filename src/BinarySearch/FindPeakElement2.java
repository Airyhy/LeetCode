package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindPeakElement2 {
    //m+n algorithm, 2D binary search
    // https://segmentfault.com/a/1190000003488794

    //nlogn algorithm
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
