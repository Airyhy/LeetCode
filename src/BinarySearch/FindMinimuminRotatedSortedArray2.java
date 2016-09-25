package BinarySearch;

/**
 *
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArray2 {



    public int findMin2(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int lo = 0, hi = nums.length -1;
        if(nums[lo]<nums[hi]){
            return nums[lo];
        }

        while(lo+1<hi){
            int mid = (hi-lo)/2 + lo;

            if(nums[mid]>nums[hi]){
                lo = mid;
            }
            else if(nums[mid]<nums[hi]){
                hi = mid;
            }
            else{
                hi--;
            }

        }

        return Math.min(nums[lo],nums[hi]);
    }
}
