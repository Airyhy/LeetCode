package BinarySearch;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 *
 */

public class FindMinimuminRotatedSortedArray {

    /**
     * Standard Binary Search
     */
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }


        int low =0, high = nums.length-1;
        if(nums[low]<=nums[high]){
            return nums[low];
        }

        while(low+1<high){
            int mid = (high-low)/2+low;

            if(nums[0]<nums[mid]){
                low = mid;
            }
            else if(nums[0]>nums[mid]){
                high = mid;
            }
            else{
                high = mid;
            }
        }

        return Math.min(nums[low],nums[high]);
    }
}