package Deque;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Given an array of n integer with duplicate number, and a moving window(size k),
 * move the window at each iteration from the start of the array,
 * find the maximum number inside the window at each moving.
 *
 *
 *
 Example
 For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]

 At first the window is at the start of the array like this

 [|1, 2, 7| ,7, 8] , return the maximum 7;

 then the window move one step forward.

 [1, |2, 7 ,7|, 8], return the maximum 7;

 then the window move one step forward again.

 [1, 2, |7, 7, 8|], return the maximum 8;

 */
public class SlidingWindowMaximum {

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<>();
        if(nums==null || nums.length==0 || k==0){
            return rst;
        }

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){

            while( ad.isEmpty()==false && ad.peek()<=i-k ){
                ad.poll();
            }

            while( ad.isEmpty()==false && nums[ad.peekLast()]<=nums[i] ){
                ad.pollLast();
            }

            ad.add(i);

            if(i>=k-1){
                rst.add(nums[ad.peek()]);
            }
        }
        return rst;
    }

}
