package TwoPointer;


import java.util.Arrays;

public class TwoSum2 {


//    Given an array of integers, find how many pairs in the array such that
//    their sum is bigger than a specific target number.
//    Please return the number of pairs.

    public int twoSum2(int[] nums, int target) {

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = 0;

        // two pointers, small to large
        while(left < right) {
            if(nums[left] + nums[right] > target) {
                ans = ans + (right - left);
                right --;
            } else {
                left ++;
            }
        }
        return ans;
    }
}
