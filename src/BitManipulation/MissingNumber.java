package BitManipulation;

/**Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity.
 Could you implement it using only constant extra space complexity?
 */



public class MissingNumber {

    /**
     * XOR
     */
    public int missingNumber(int[] nums) {
        if (nums ==null) return 0;
        int all=0, i;
        for(i=0;i<nums.length;i++){
            all = all^nums[i]^i;
        }
        return all^i;
    }

    //Add all possible number and reduce one by one
    public int missingNumber2(int[] nums) { //sum
        int len = nums.length;
        int sum = (0+len)*(len+1)/2;
        for(int i=0; i<len; i++)
            sum-=nums[i];
        return sum;
    }


}

