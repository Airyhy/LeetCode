package DP.DP_seuqence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class houseRobber {


    public int rob(int[] nums) {
        if(nums==null || nums.length==0 ){
            return 0;
        } else if (nums.length==1){
            return nums[0];
        }

        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){

            max[i] = Math.max(max[i-1],max[i-2]+nums[i]);
        }

        return max[nums.length-1];
    }



    public List<Integer> houseRobberGetPos(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return Arrays.asList(0);
        }

        int even = nums[0];
        List<Integer> evenList = new ArrayList<>();
        evenList.add(0);

        int odd;
        List<Integer> oddList = new ArrayList<>();
        if (nums[0] > nums[1]) {
            odd = nums[0];
            oddList.add(0);
        } else {
            odd = nums[1];
            oddList.add(1);
        }

        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (even + nums[i] > odd) {
                    even += nums[i];
                    evenList.add(i);
                } else {
                    even = odd;
                    evenList = new ArrayList<>(oddList);
                }
            } else {
                if (odd + nums[i] > even) {
                    odd += nums[i];
                    oddList.add(i);
                } else {
                    odd = even;
                    oddList = new ArrayList<>(evenList);
                }
            }
        }

        return even > odd ? evenList : oddList;
    }
}
