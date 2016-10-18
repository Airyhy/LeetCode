package VFacebookTemp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Christina on 3/2/16.
 */
public class primeProducts {


    //BFS //Prime, there is no duplucate
    public List<Integer> subsetProduct(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                ret.add(nums[i] * ret.get(j));
            }
            ret.add(nums[i]);
        }
        //remove the duplicated ones
        return new ArrayList<>(new HashSet<>(ret));
    }


    //DFS
    private List<Integer> result = new ArrayList();

    public List<Integer> subsetProduct1(int[] nums) {
        int len = nums.length;
        if( len == 0 ) return result;
        List<Integer> entry = new ArrayList();
        Arrays.sort(nums);

        DFS(0,nums,1);
        return result;
    }

    private void DFS(int index,int[] nums, int pre){

        result.add(pre);

        for(int i = index; i < nums.length; i++){

            DFS( i + 1, nums, nums[i]*pre );
        }
    }


    /**
     * Follow up pn limited times
     */
    public void primeProduct(int[] prime, int[] times) {
        if (prime.length == 0) {
            System.out.println(1);
            return;
        }

        backtrack(prime, times, 1,0);
    }

    private void backtrack(int[] prime, int[] times, int pre, int idx) {
        for (int i = idx; i < times.length; i++) {
            if (times[i] > 0) {
                times[i]--;

                System.out.println(pre);
                backtrack(prime, times, pre*prime[i],i);

                times[i]++;
            }
        }
    }

}
