package Array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {

    /**
     * O(n+m)
     * Merge two sorted list and count the number
     * Use two pointers to move forward
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int total_length=nums1.length+nums2.length;
        int mid=(total_length-1)/2;
        boolean isodd=(total_length%2==1);
        int i=0,j=0;
        double e1=0,e2=0;
        for(int k=0;k<total_length;k++){
            int cur;
            if(i>nums1.length-1){
                cur=nums2[j];
                j++;
            }
            else if(j>nums2.length-1){
                cur=nums1[i];
                i++;
            }
            else if(nums1[i]>nums2[j]){
                cur=nums2[j];
                j++;
            }
            else{
                cur=nums1[i];
                i++;
            }

            if(k==mid){
                e1=cur;
            }
            if(k==(mid+1)){
                e2=cur;
            }
        }
        if(isodd){
            return e1;
        }
        return (e1+e2)/2;
    }


    /**
     * O(log(min(m,n)))
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if( len%2==1){
            return getkth(nums1,0,nums2,0,len/2+1);
        }else{
            int re1 = getkth(nums1,0,nums2,0,len/2);

            int re2 = getkth(nums1,0,nums2,0,len/2+1);

            return (re1+re2)/2.0;
        }

    }

    public int getkth(int[] A,int sa,int[] B, int sb, int k){
        if(sa>=A.length) return B[sb+k-1];
        if(sb>=B.length) return A[sa+k-1];

        if(k==1) {
            return Math.min(A[sa],B[sb]);
        }

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if(sa+k/2-1<A.length) aMid = A[sa+k/2 -1];
        if(sb+k/2-1<B.length) bMid = B[sb+k/2 -1];

        if(aMid<bMid){
            return getkth(A,sa+k/2,B,sb,k-k/2);
        }
        else{
            return getkth(A,sa,B,sb+k/2,k-k/2);
        }
    }
}
