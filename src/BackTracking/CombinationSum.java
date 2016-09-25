package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 Given a set of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        recurs(new ArrayList<Integer>() ,candidates, target,0);
        return result;
    }

    public void recurs(List<Integer> temp, int[] cand, int target,int j){
        if(target==0){
            result.add(temp);
            return;
        }

        for(int i=j;i<cand.length;i++){
            if(target-cand[i]>=0){
                List<Integer> temp1 = new ArrayList<Integer>(temp);
                temp1.add(cand[i]);
                recurs(temp1 ,cand, target-cand[i],i);
            }
            else{
                break;
            }
        }
        return;
    }

}
