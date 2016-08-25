package BackTracking;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        if(target==0){
            return 1;
        }

        int[] dp = new int[target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0; j<nums.length;j++){

                //try all the possible nodes
               if(i==nums[j]){
                    dp[i] += 1;
                } else if(i>nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }
}
