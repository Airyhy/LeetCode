package VFacebookTemp;

/**

 Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

 Hint:
 Expected runtime complexity is in O(log n) and the input is sorted.

 */
public class hIndex2 {

    /**
     * Binary Search [0,0,0,3,4,4]. Only nums[3] = len - i works.
     */

    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0){
            return 0;
        }
        int lo = 0, hi = citations.length - 1;
        while(lo<hi-1){
            int mid = (hi - lo)/2 + lo;
            if(citations[mid] < citations.length - mid){
                lo = mid;
            } else if(citations[mid] == citations.length - mid){
                return  citations.length - mid;
            } else {
                hi = mid;
            }
        }

        if(citations[lo] >= citations.length - lo){
            return citations.length - lo;
        }

        if(citations[hi] >= citations.length - hi){
            return citations.length - hi;
        }

        return 0;
    }
}
