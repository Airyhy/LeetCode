package BinarySearch;

/**
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArray2 {


    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return false;
        int low = 0, high = nums.length - 1;


        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if(nums[mid]==target){
                return true;
            }

            if (nums[mid] > nums[low] || nums[mid]>nums[high] ) {

                if(nums[mid]>target && target>=nums[low]){
                    high = mid;
                }
                else{
                    low = mid;
                }
            } else if(nums[mid] <nums[low]  ||nums[mid]<nums[high]){
                if(nums[mid]<target && target<=nums[high]){
                    low = mid;
                }
                else{
                    high = mid;
                }

            }
            else{
                high--;
            }
        }
        if(nums[low]==target){
            return true;
        }
        else if(nums[high]==target){
            return true;
        }
        return false;
    }

}
