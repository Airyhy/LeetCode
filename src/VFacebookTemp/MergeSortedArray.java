package VFacebookTemp;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to
 hold additional elements from nums2.

 The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0)  {
            return;
        }

        int ib = n-1;
        int ia = m-1;
        for(int i=m+n-1;i>=0;i--){
            if(ia<0) nums1[i] = nums2[ib--];
            else if(ib<0) nums1[i] = nums1[ia--];
            else if(nums1[ia]>=nums2[ib]) nums1[i] = nums1[ia--];
            else nums1[i] = nums2[ib--];
        }
        return;
    }



    //merge into a new array
    public int[] merge2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] ret = new int[m + n];
        int p1 = 0, p2 = 0, p = 0;
        while (p1 < m && p2 < n) {
            ret[p++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < m) {
            ret[p++] = nums1[p1++];
        }
        while (p2 < n) {
            ret[p++] = nums2[p2++];
        }
        return ret;
    }
}
