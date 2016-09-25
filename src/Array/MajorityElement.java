package Array;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    /**
     *
     * Voting algorithm
     */
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int count = 0;
        int temp = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==temp){
                count++;
            }else if(count!=0){
                count--;
            }else{
                count++;
                temp = nums[i];
            }
        }
        return temp;
    }
}
