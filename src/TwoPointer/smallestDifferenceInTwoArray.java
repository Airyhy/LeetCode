package TwoPointer;

import java.util.Arrays;

/**
 * Given two array of integers(the first array is array A,
 * the second array is array B), now we are going to find a element in array A which is A[i],
 * and another element in array B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|)
 * is as small as possible, return their smallest difference.

 For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
 */
public class smallestDifferenceInTwoArray {

    public int smallestDifference(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int ai = 0, bi = 0;
        int min = Integer.MAX_VALUE;
        while (ai < A.length && bi < B.length) {
            min = Math.min(min, Math.abs(A[ai] - B[bi]));
            if (A[ai] < B[bi]) {
                ai++;
            } else {
                bi++;
            }
        }
        return min;
    }
}
