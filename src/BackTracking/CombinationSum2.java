package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<Integer>();
        recurs(temp ,candidates, target, result,0);
        return result;
    }

    public void recurs(List<Integer> temp, int[] cand, int target,  List<List<Integer>> result,int j){
        if(target==0){
            result.add(temp);
            return;
        }
        for(int i=j;i<cand.length;i++){
            if(target-cand[i]>=0){
                if(i>j && cand[i]==cand[i-1]) { continue; }
                List<Integer> temp1 = new ArrayList<Integer>(temp);
                temp1.add(cand[i]);
                recurs(temp1 ,cand, target-cand[i], result,i+1);
            }
            else{
                break;
            }
        }
        return;
    }

}
