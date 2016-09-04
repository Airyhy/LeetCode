package DP.DP_interval;

/**
 *
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        // write your code here
        if( nums==null || nums.length==0 ){
            return 0;
        }

        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        int product = nums[0];

        for(int i=1; i<nums.length;i++){
            min[i] = Math.min(nums[i],max[i-1]*nums[i]);
            min[i] = Math.min(min[i],min[i-1]*nums[i]);

            max[i] = Math.max(nums[i],min[i-1]*nums[i]);
            max[i] = Math.max(max[i],max[i-1]*nums[i]);
            product = Math.max(max[i],product);
        }

        return product;
    }
}
