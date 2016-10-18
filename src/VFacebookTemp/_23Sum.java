package VFacebookTemp;

import java.util.*;
public class _23Sum{
	public static void main(String[] args){
	
	}

	//	Two Sum
	public int[] twoSum(int[] nums, int target) {
        if(nums==null) return nums;
        Map<Integer,Integer> newnums = new HashMap<Integer,Integer>();
        int[] rtr = new int[2];
        for(int i=0;i<nums.length;i++){
            if(newnums.containsKey(target-nums[i])){
				rtr[0] = newnums.get(target-nums[i]);
				rtr[1] = i;
                return rtr; 
            }
            newnums.put(nums[i],i);
        }
        return rtr;
        
    }
	//	If the input is a stream, how to do that?
	//	(external sort, and then use two pointers from two sides)


	//3sum by 2 pointers
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		int len = nums.length;
		for(int i=0;i<len-2;i++){
			//avoid useless increase
			if(i!=0 &&  nums[i]==nums[i-1]){
				continue;
			}

			int lo = i+1;
			int hi = len-1;
			int need = 0-nums[i];

			while(lo<hi){
				if(nums[lo]+nums[hi]==need){
					List<Integer> temp = Arrays.asList(nums[i],nums[lo],nums[hi]);
					result.add(temp);
					while (lo < hi && nums[lo] == nums[lo + 1]) { lo++;}
					while (lo < hi && nums[hi] == nums[hi - 1]) { hi--;}
					lo++;
					hi--;
				}
				else if(nums[lo]+nums[hi]>need){
					hi--;
				}
				else if(nums[lo]+nums[hi]<need){
					lo++;
				}
			}
		}
		return result;
	}

	//3sum by hashMap
	public List<List<Integer>> threeSum2(int[] nums) {
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

	  //Three Sum closet
	  public int threeSumClosest(int[] num, int target) {
		  if(num == null || num.length<3){
			  return 0;
		  }
		  //sort array
		  Arrays.sort(num);
		  int len = num.length;
		  int res = num[0] + num[1] + num[2];


		  for(int small=0; small<len-2; small++){
			  int mid = small + 1;
			  int large = len - 1;
			  while(mid < large){

				  int sum = num[small] + num[mid] + num[large];
				  if(sum == target){
					  return target;
				  }else if(sum < target){
					  mid ++;
				  }else{
					  large --;
				  }
				  if(Math.abs(sum-target) < Math.abs(res-target)){
					  res = sum;
				  }
			  }
		  }
		  return res;
	  }
}