package DP.DP_seuqence;

/**
 * After robbing those houses on that street,
 * the thief has found himself a new place for his thievery so that he will not get too much attention.
 *
 * This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
 * the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 */
public class houseRobber2 {


    // have 2 DP array iterations

    public int rob2_2(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        } else if( nums.length==1){
            return nums[0];
        }

        int[] max1 = new int[nums.length]; //have 0
        int[] max2 = new int[nums.length]; //no 0

        max1[0] = nums[0];
        max1[1] = nums[0];

        max2[0] = 0;
        max2[1] = nums[1];

        for(int i=2;i<nums.length;i++){
            if(i==nums.length-1){
                max1[i] = Math.max(max1[i-1],max1[i-2]);
            }else{
                max1[i] = Math.max(max1[i-1],max1[i-2]+nums[i]);
            }

            max2[i] = Math.max(max2[i-1],max2[i-2]+nums[i]);
        }
        return Math.max(max1[nums.length-1],max2[nums.length-1]);
    }


    // use house robber 1

    public int rob2_1(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
    }

    public int rob1(int[] nums, int st, int ed) {
        int []res = new int[2];
        if(st == ed) {
            return nums[ed];
        }
        if(st+1 == ed) {
            return Math.max(nums[st], nums[ed]);
        }

        res[st%2] = nums[st];
        res[(st+1)%2] = Math.max(nums[st], nums[st+1]);

        for(int i = st+2; i <= ed; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + nums[i]);

        }
        return res[ed%2];
    }


}
