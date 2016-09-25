package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 Find all possible combinations of k numbers that add up to a number n,
 given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Example 1:
 Input: k = 3, n = 7
 Output:
 [[1,2,4]]

 Example 2:
 Input: k = 3, n = 9
 Output:
 [[1,2,6], [1,3,5], [2,3,4]]
 *
 *
 */
public class CombinationSum3 {
    int count = 0;
    int[] candidates = {1,2,3,4,5,6,7,8,9};
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> entry = new ArrayList<Integer>();
        count = k;

        recurs(entry , candidates, n,0);
        return result;
    }

    public void recurs(List<Integer> entry, int[] cand, int target, int j){
        if(entry.size()>count){
            return;
        }
        if(target==0 && entry.size()==count){
            result.add(new ArrayList<Integer>(entry));
            return;
        }

        for(int i=j;i<cand.length;i++){
            if(target-cand[i]>=0){
                List<Integer> newentry = new ArrayList<Integer>(entry);
                newentry.add(cand[i]);
                recurs(newentry ,cand, target-cand[i],i+1);
            }
            else{
                break;
            }
        }
        return;
    }
}
