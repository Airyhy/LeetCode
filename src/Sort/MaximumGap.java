package Sort;

import java.util.Arrays;

/**
 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

 Given [1, 9, 2, 5], the sorted form of it is [1, 2, 5, 9], the maximum gap is between 5 and 9 = 4.

 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        //find max min
        int max = nums[0],min = nums[0];
        for(int i:nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }

        //find gap to make at least one bucket is empty
        //so that we will only need to consider diff between gaps
        int gap = (int)Math.ceil((double)(max-min)/(nums.length-1));
        int[] newnummax = new int[nums.length-1];
        int[] newnummin = new int[nums.length-1];
        Arrays.fill(newnummax,Integer.MIN_VALUE);
        Arrays.fill(newnummin,Integer.MAX_VALUE);

        for(int i:nums){
            if (i == min || i == max)
                continue;
            int index = (i-min) / gap;
            //System.out.println(index);

            newnummax[index] = Math.max(i,newnummax[index]);
            newnummin[index] = Math.min(i,newnummin[index]);
        }

        int result = 0;
        int prev = min;
        for(int i=0;i<newnummax.length;i++){
            //  System.out.println("bb");
            if(newnummin[i]==Integer.MAX_VALUE && newnummax[i]==Integer.MIN_VALUE){
                continue;
            }
            result = Math.max(result,newnummin[i]-prev );
            prev = newnummax[i];
        }

        return Math.max(result,max-prev);
    }
}
