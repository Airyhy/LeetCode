package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 *
 * Given an integer array, find a subarray where the sum of numbers is zero.
   Your code should return the index of the first number and the index of the last number.
 */

public class subarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {

        ArrayList<Integer> rst = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        //set up a pre-compute sum = 0;

        int sum = 0;
        map.put(0,-1);
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];

            if(map.containsKey(sum)){
                rst.add(map.get(sum)+1);
                rst.add(i);
                return rst;
            }
            map.put(sum,i);
        }
        return rst;
    }
}
