package Greedy;

/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 Note:
 You can assume that you can always reach the last index.

 */
public class JumpGame2 {


    public int jump(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;

        int edge = 0; //the end of this level
        int reach = nums[0]; //the point can reach this level
        int step = 0; //steps of move

        for(int i=0;i<len;i++){
            if(edge>=len-1){
                return step;
            }
            if(i>edge){
                step++;
                edge = reach;
            }
            // System.out.println(reach);
            reach = Math.max(reach,nums[i]+i);

        }
        return step;
    }
}
