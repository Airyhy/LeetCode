package VFacebookTemp;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */

public class sortColor {

    public void sortColors(int[] nums) {
        if(nums.length<2) return ;
        int end = nums.length - 1;
        int start = 0, index = 0;

        while(index<=end){
            if(nums[index]==0){
                swap(nums,start,index);
                start++;
                index++;
            }
            else if(nums[index]==2){
                swap(nums,end,index);
                end--;
            }
            else{
                index++;
            }

        }
        return ;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    //there are k types
    //O(n + k)
    public void sortKColors(int[] nums, int k) {
        int[] count = new int[k];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < k; i++) {
            Arrays.fill(nums, idx, idx + count[i], i);
            idx += count[i];
        }
    }

}
