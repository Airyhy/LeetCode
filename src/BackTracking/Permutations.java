package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning

 */
public class Permutations {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {

        if(nums==null || nums.length==0) {
            return result;
        }

        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);

        dfs(nums, used, new ArrayList<Integer>());
        return result;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> entry){
        if(entry.size()==nums.length){
            result.add(entry);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) {
                continue;
            }

            used[i]=true;
            List<Integer> newEntry = new ArrayList<>(entry);
            newEntry.add(nums[i]);
            dfs(nums,used,newEntry);
            used[i]=false;
        }
    }

}
