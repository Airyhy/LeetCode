package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Subsets2 {


    /**
     * Recursive
     */
    private List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        if(len ==0 ) return result;
        List<Integer> entry = new ArrayList();
        Arrays.sort(nums);

        DFS(0,nums,entry);
        return result;
    }

    public void DFS(int index,int[] nums,List<Integer> entry){
        result.add(entry);

        for(int i=index;i<nums.length;i++){
            if( i>index && nums[i]==nums[i-1] ) {
                continue;
            }

            List<Integer> newEntry = new ArrayList<>(entry);
            newEntry.add(nums[i]);
            DFS(i+1,nums,newEntry);
        }

    }

    /**
     * Iteration
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int begin = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]) {
                begin = 0;
            }

            int size = result.size();
            for(int j = begin; j < size; j++){
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            begin = size;
        }
        return result;
    }
}
