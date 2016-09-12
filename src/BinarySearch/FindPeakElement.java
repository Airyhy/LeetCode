package BinarySearch;


/** There is an integer array which has the following features:

        The numbers in adjacent positions are different.
        A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
        We define a position P is a peek if:

        A[P] > A[P-1] && A[P] > A[P+1]
        Find a peak element in this array. Return the index of the peak.

        Notice

        The array may contains multiple peeks, find any of them.

        Have you met this question in a real interview? Yes
        Example
        Given [1, 2, 1, 3, 4, 5, 7, 6]

        Return index 1 (which is number 2) or 6 (which is number 7)

 */

public class FindPeakElement {

    public int findPeak(int[] A) {

        int l = 0, r = A.length - 1;
        int mid = A[0];
        while(r>=l){
            mid = (r - l)/2 + l;
            if(A[mid] < A[mid-1]){
                r = mid;
            } else if(A[mid] < A[mid+1]){
                l = mid;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
