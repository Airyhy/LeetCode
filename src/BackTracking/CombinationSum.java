package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                List<Integer> temp1 = new ArrayList<Integer>(temp);
                temp1.add(cand[i]);
                recurs(temp1 ,cand, target-cand[i], result,i);
            }
            else{
                break;
            }
        }
        return;
    }

}
