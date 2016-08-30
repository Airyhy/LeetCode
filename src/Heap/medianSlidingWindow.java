package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array of n integer, and a moving window(size k),
 * move the window at each iteration from the start of the array,
 * find the median of the element inside the window at each moving.
 * (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )

 Have you met this question in a real interview? Yes
 Example
 For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

 At first the window is at the start of the array like this

 [ | 1,2,7 | ,8,5] , return the median 2;

 then the window move one step forward.

 [1, | 2,7,8 | ,5], return the median 7;

 then the window move one step forward again.

 [1,2, | 7,8,5 | ], return the median 7;
 */
public class medianSlidingWindow {


    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        PriorityQueue<Integer> maxp = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        PriorityQueue<Integer> minp = new PriorityQueue<Integer>();

        if(nums==null || nums.length==0 || k==0 ){
            return rst;
        }

        //load
        for(int i=0;i<k;i++){
            maxp.add(nums[i]);
            minp.add(maxp.poll());
            resize(maxp,minp);
        }

        rst.add(maxp.peek());

        //add and remove
        for(int i=0;i<nums.length-k;i++){
            remove(maxp,minp,nums[i]);
            maxp.add(nums[i+k]);
            minp.add(maxp.poll());
            resize(maxp,minp);
            rst.add(maxp.peek());
        }

        return rst;
    }

    public void resize(PriorityQueue<Integer> maxp,PriorityQueue<Integer> minp){
        while(maxp.size()<minp.size()){
            maxp.add(minp.poll());
        }
    }

    public void remove(PriorityQueue<Integer> maxp,PriorityQueue<Integer> minp,int num){
        if(maxp.remove(num)){
            return;
        }else{
            minp.remove(num);
        }
    }

}
