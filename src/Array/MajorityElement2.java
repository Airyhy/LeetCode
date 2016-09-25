package Array;

import java.util.LinkedList;
import java.util.List;

/**
 *Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.

 Hint:
 How many majority elements could it possibly have?
 */
public class MajorityElement2 {


    //Voting algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> firesult = new LinkedList<>();
        int len = nums.length;

        int count1 = 0,count2 = 0;
        int vote1 = 0, vote2 = 0;

        for(int i:nums){
            if(vote1==i){
                count1++;
            }
            else if(vote2==i){
                count2++;
            }
            else if(count1==0 ){
                count1++;
                vote1 = i;
            }
            else if(count2==0){
                count2++;
                vote2 = i;
            }
            else{
                count1-- ;
                count2-- ;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i:nums){
            if(i==vote1) count1++;
            else if(i==vote2) count2++;
        }

        if(count1>(len/3)) firesult.add(vote1);
        if(count2>(len/3)) firesult.add(vote2);
        return firesult;
    }
}
