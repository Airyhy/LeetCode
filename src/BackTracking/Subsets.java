package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */

public class Subsets {

    private List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if(len ==0 ) return result;
        List<Integer> entry = new ArrayList();
        Arrays.sort(nums);

        DFS(0,nums,entry);
        return result;
    }


    private void DFS(int index,int[] nums,List<Integer> entry){
        result.add(entry);

        for(int i = index; i < nums.length; i++){
            List<Integer> newEntry = new ArrayList<>(entry);
            newEntry.add(nums[i]);
            DFS( i + 1, nums, newEntry );
        }
    }

}
