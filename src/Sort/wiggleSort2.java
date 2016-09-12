package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wiggleSort2 {

    /**
     * Given an unsorted array nums, reorder it such that

     nums[0] < nums[1] > nums[2] < nums[3]....
     Notice

     You may assume all input has valid answer.

     Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].

     Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
     *
     */


// O(nlogn) sort and set
    public void wiggleSort1(int[] nums) {
        if (nums == null)
            return;

        int n = nums.length;
        int left = n;
        int mid = (n - 1) / 2 + 1;

        Arrays.sort(nums);
        int neoNums[] = new int[n];

        for (int i = 0; i < n; i++)
            neoNums[i] = (i & 1) == 0 ? nums[--mid] : nums[--left];

        for (int i = 0; i < n; i++)
            nums[i] = neoNums[i];

        return;
    }

//    O(n), find median number and then set
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if(len<2) return;

        double median = 0;
        if(nums.length % 2 == 1) {
            median = (double) findmiddle(nums,nums.length/2 + 1);
        }
        else {
            median = ( (double) findmiddle(nums, nums.length/2 + 1) + (double) findmiddle(nums, nums.length/2) ) / 2;
        }


        int firstHalfLen, secondHalfLen;
        if(nums.length % 2 == 0) {
            firstHalfLen = nums.length/2;
        } else {
            firstHalfLen = nums.length/2+1;
        }
        secondHalfLen = nums.length/2;

        List<Integer> firstHalf  = new ArrayList<Integer>();
        List<Integer> secondHalf = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            if((double) nums[i] < median) firstHalf.add(nums[i]);
            else if((double) nums[i] > median) secondHalf.add(nums[i]);
        }

        while(firstHalf.size() < firstHalfLen) {
            firstHalf.add((int) median);
        }
        while(secondHalf.size() < secondHalfLen) {
            secondHalf.add((int) median);
        }

        for(int i = 0; i < firstHalf.size(); i++) {
            nums[i*2] = firstHalf.get(firstHalf.size()-1-i);
        }
        for(int i = 0; i < secondHalf.size(); i++) {
            nums[i*2+1] = secondHalf.get(i);
        }



    }

    public int findmiddle(int[] nums, int k) {
        int start = 0, end = nums.length -1, dest = nums.length -k;
        while(start<end){
            int pivot = partion(nums,start,end);
            if(pivot>dest){
                end = pivot -1;
            }
            else if(pivot<dest){
                start = pivot + 1;
            }
            else{
                return nums[pivot];
            }
        }
        return nums[dest];
    }

    public int partion(int[] nums, int start, int end){
        int temp = nums[start];

        while(start<end){
            while(start<end && nums[end]>=temp) {
                end--;
            }
            nums[start] = nums[end];

            while(start<end && nums[start]<=temp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[end] = temp;
        return end;
    }
}
