酥mimport java.util.*;

/**
 * Created by Christina on 12/22/15.
 */
public class _3Sum {

    //two pointers
    //O(n^2)  O(1)
    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    while (left < right && nums[left] == nums[left + 1]) { left++;}
                    while (left < right && nums[right] == nums[right - 1]) { right--;}
                    ret.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) { i++;}
        }
        return ret;
    }


    //hashmap
    //O(n^2), O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        int key;
        Arrays.sort(nums);

        List<List<Integer>> result=new ArrayList<List<Integer>>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++) map.put(nums[i],i);

        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;  //Avoid duplication

            for(int j=i+1;j<nums.length-1;j++){
                if(j!=i+1&&nums[j]==nums[j-1]) continue; //Avoid duplication
                key=0-nums[i]-nums[j];

                if(map.containsKey(key)&&(map.get(key)>j))
                    result.add(Arrays.asList(nums[i], nums[j], key));
            }
        }
        return result;
    }


    //every one can be duplicated
    //two pointers
    //O(n ^ 2)
    public List<List<Integer>> threeSum2 (int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i, right = nums.length - 1;
            while (left <= right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    while (left < right && nums[left] == nums[left + 1]) { left++;}
                    while (left < right && nums[right] == nums[right - 1]) { right--;}
                    ret.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) { i++;}
        }
        return ret;
    }

    public static void main(String[] arg) {
        _3Sum a = new _3Sum();
        System.out.println(a.threeSum(new int[]{-1, 0, 1, 2, -1, 4}, 0));
        System.out.println(a.threeSum1(new int[]{-1, 0, 1, 2, -1, 4}, 0));
        System.out.println(a.threeSum2(new int[]{-1, 0, 1, 2, -1, 4}, 0));

        System.out.println(a.threeSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(a.threeSum1(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(a.threeSum2(new int[]{0, 0, 0, 0, 0}, 0));


        System.out.println(a.threeSum2(new int[]{1}, 3));
    }
}
