package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        List<Integer> temp = new ArrayList<Integer>();
        recurs(temp ,candidates, n, result,0,k);
        return result;
    }

    public void recurs(List<Integer> temp, int[] cand, int target,  List<List<Integer>> result,int j,int k){
        if(temp.size()>k){
            return;
        }
        if(target==0){
            if(temp.size()==k){
                result.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        for(int i=j;i<cand.length;i++){
            if(target-cand[i]>=0){
                temp.add(cand[i]);
                recurs(temp ,cand, target-cand[i], result,i+1,k);
                temp.remove(temp.size()-1);
            }
            else{
                break;
            }
        }
        return;
    }
}
