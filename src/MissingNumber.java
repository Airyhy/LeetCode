//missing number，
//在1,2..N里面找出missing number
//https://leetcode.com/problems/missing-number/

//use xor
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums ==null) return 0;
        int all=0, i;
        for(i=0;i<nums.length;i++){
            all = all^nums[i]^i;
        }
        return all^i;
    }
}

//Add all possible number and reduce one by one
public int missingNumber(int[] nums) { //sum
    int len = nums.length;
    int sum = (0+len)*(len+1)/2;
    for(int i=0; i<len; i++)
        sum-=nums[i];
    return sum;
}
