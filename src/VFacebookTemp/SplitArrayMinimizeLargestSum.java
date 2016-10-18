package VFacebookTemp;

/**
 * Given an array which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.

 Note:
 Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.

 Examples:

 Input:
 nums = [7,2,5,10,8]
 m = 2

 Output:
 18

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8],
 where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayMinimizeLargestSum {

    /**
     Given a result, it is easy to test whether it is valid or not.
     The max of the result is the sum of the input nums.
     The min of the result is the max num of the input nums.
     Given the 3 conditions above we can do a binary search. (need to deal with overflow)
     */

    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        return (int)binary(nums, m, sum, max);
    }

    private long binary(int[] nums, int m, long high, long low){
        long mid = 0;
        while(low +1 < high){
            mid = (high + low)/2;
            if(valid(nums, m, mid)){
                //System.out.println(mid);
                high = mid;
            }else{
                low = mid;
            }
        }
        if(valid(nums,m,low)){
            return low;
        }
        return high;
    }

    private boolean valid(int[] nums, int m, long max){
        System.out.println(max);
        int cur = 0;
        int count = 0;
        for(int num: nums){
            cur += num;
            if(cur > max){
                cur = num;
                count++;
                if(count >= m){
                    return false;
                }
            }
        }
        return true;
    }
}
