package QuickSort;

public class KthLargest {

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
}
