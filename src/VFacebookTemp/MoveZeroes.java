package VFacebookTemp;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length<2){
            return;
        }
        int j = 0;

        //move all non-zero to front
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }
        }

        for(;j<nums.length;j++){
            nums[j] = 0;
        }

        return;
    }
}
