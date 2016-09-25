package Array;

/**
 *Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class NextPermutation {


    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length < 2)
            return;

        int len = nums.length;
        int idx = nums.length - 2;

        //find the exchange point, smalledst number from the end
        while(idx >= 0 && nums[idx] >= nums[idx + 1]){
            idx--;
        }

        //always increasing, largest, change to smallest
        if(idx < 0){
            reverse(nums,0);
            return;
        }

        int j = nums.length - 1;

        //find the one just larger than the smallest point
        while(j>=0 && nums[j]<=nums[idx]){
            j--;
        }

        //rest the larger one and reverse end
        swap(nums,idx,j);
        reverse(nums,idx+1);

    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int index) {
        int l = index;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }

    }
}
