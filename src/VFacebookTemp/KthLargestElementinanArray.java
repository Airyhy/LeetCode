package VFacebookTemp;

import java.util.PriorityQueue;

/**

Example
In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

 */
public class KthLargestElementinanArray {


    /**
     * O(n)
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int i=0, j=len-1;
        int target = len - k;

        while(i<j){
            int mid = partition(nums,i,j);
            if(mid == target){
                return nums[mid];
            } else if(mid < target){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return nums[i];
    }

    public int partition(int[] nums, int i, int j){
        int temp = nums[i];
        while(i<j){
            while(i<j && nums[j]>=temp){
                j--;
            }
            nums[i] = nums[j];
            while(i<j && nums[i]<=temp){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = temp;
        return i;
    }


    /**
     * nlogk
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for(int i=0;i<k;i++){
            heap.offer(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(heap.peek()<nums[i]){
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }
}
