package DP.DP_interval;

/**
 *
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int temp = 1;
        for(int i=0;i<len;i++){
            res[i] = temp;
            temp = res[i]*nums[i];
        }

        temp = 1;
        for(int i=len-1;i>=0;i--){
            res[i] = res[i]*temp;
            temp = temp*nums[i];
        }
        return res;
    }

}
