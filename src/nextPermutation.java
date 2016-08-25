// 比如排列是(2,3,6,5,4,1)
// 1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
// 2) 接下来分两种情况：
//     (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
//     (2) 否则，如果p存在，从p开始往后找，找到下一个数就比p对应的数小的数字，然后两个调换位置，比如例子中的4。调换位置后得到(2,4,6,5,3,1)。
//		最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 这个即是要求的下一个排列。


//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//The replacement must be in-place, do not allocate extra memory.
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class nextPermutation{    
	public void nextPermutation(int[] nums) {
        if(nums==null || nums.length < 2)
            return;
            
        int len = nums.length;
        int idx = nums.length - 2;
        while(idx >= 0 && nums[idx] >= nums[idx + 1]){ 
            idx--; 
        }

        if(idx < 0){
            reverse(nums,0);
            return;
        }
        
        int j = nums.length - 1;
        while(j>=0 && nums[j]<=nums[idx]){
            j--;
        }
        swap(nums,idx,j);
        reverse(nums,idx+1);
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int index)  
    {  
        int l = index;  
        int r = nums.length-1;  
        while(l<r)  
        {  
            swap(nums,l++,r--);  
        }  
    }
    
    

  //Given a collection of distinct numbers, return all possible permutations.
  //
  //For example,
  //[1,2,3] have the following permutations:
  //[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0) {
            return permutations;
        }

        collectPermutations(nums, 0, new ArrayList<>(), permutations);
        return permutations;
    }

    private void collectPermutations(int[] nums, int start, List<Integer> permutation,
            List<List<Integer>>  permutations) {

        if (permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }

        for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start + 1, newPermutation, permutations);
        }
    }
}
