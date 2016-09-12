package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an integer array, find a subarray with sum closest to zero.
 * Return the indexes of the first number and last number.

   Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 */
public class SubarraySumClosest {
    class Pair {
        int sum;
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }


    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        int len = nums.length;
        if(len == 1) {
            res[0] = 0 ;
            res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[len+1];
        int prev = 0;
        sums[0] = new Pair(0,0);

        //like subarray sum, create a new Array with all previous sums
        for(int i=1;i<=nums.length;i++){
            sums[i] = new Pair(prev+nums[i-1],i);
            prev = prev+nums[i-1];
        }

        //sort it to find smallest difference
        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });

        //compare the find smallest diff
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {

            if (max > sums[i].sum - sums[i-1].sum) {
                max = sums[i].sum - sums[i-1].sum;

                res[0] = sums[i].index-1;
                res[1] = sums[i-1].index-1;
                Arrays.sort(res);

                //the index is res[0], but you will need all nums behind it until res[i]
                res[0] += 1;
            }
        }
        return res;
    }

}
