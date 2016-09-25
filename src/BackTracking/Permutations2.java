package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]


 * If we are allowed to sort the array, we could sort the array to let the same number cluster together.
 * In this way, avoiding duplicates, which is to avoid the same number being the first number in the permutation,
 * is simplified bacause we can judge is a number is the same as its previous one and if its previous one has been used.
 *
 * We keep a boolean array to store the numbers being used, whose values are false originally.
 * Each time we use a number, we set its corresponding value in boolean array to be true.
 * And we try further down in the recursion.
 * Once the recursion returns, we backtrack by changing its corresponding boolean value to be false and remove it
 * from the current result.
 * O(n!) time, O(n) space.
 */
public class Permutations2 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        if(nums==null || nums.length==0) {
            return result;
        }

        boolean[] used = new boolean[nums.length];
        List<Integer> entry = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, entry);
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
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) {
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
