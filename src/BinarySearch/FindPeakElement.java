package BinarySearch;

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
