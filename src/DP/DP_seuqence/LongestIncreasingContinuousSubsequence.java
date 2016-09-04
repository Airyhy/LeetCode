package DP.DP_seuqence;

/**
 *
 Give an integer array，find the longest increasing continuous subsequence in this array.

 An increasing continuous subsequence:

 Can be from right to left or from left to right.
 Indices of the integers in the subsequence should be continuous.
 Notice

 O(n) time and O(1) extra space.

 For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

 For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 */
public class LongestIncreasingContinuousSubsequence {

    public int longestIncreasingContinuousSubsequence(int[] A) {

        if( A==null || A.length==0 ){
            return 0;
        }

        int len = A.length;
        int max = 1;
        int curlen = 1;

        for(int i=1; i<len; i++){
            if(A[i]>A[i-1]){
                curlen++;
            } else {
                curlen = 1;
            }
            max = Math.max(max,curlen);
        }

        for(int i=len-2; i>=0; i--){
            if(A[i]>A[i+1]){
                curlen++;
            } else {
                curlen = 1;
            }
            max = Math.max(max,curlen);
        }

        return max;
    }

}
