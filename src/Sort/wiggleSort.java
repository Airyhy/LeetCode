package Sort;


public class wiggleSort {

//    Given an unsorted array nums, reorder it in-place such that
//    nums[0] <= nums[1] >= nums[2] <= nums[3]..

    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<2){
            return;
        }

        for(int i=1;i<nums.length;i++){
            if( i%2==1 && nums[i]<nums[i-1]){
                swap(nums,i-1,i);
            } else if (i%2==0 && nums[i]>nums[i-1]){
                swap(nums,i-1,i);
            }

        }
        return;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
