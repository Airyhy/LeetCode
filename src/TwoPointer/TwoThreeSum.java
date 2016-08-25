package TwoPointer;

import java.util.*;
public class TwoThreeSum{
	public static void main(String[] args){
	
	}

	//	Two Sum
	public int[] twoSum(int[] nums, int target) {
        if(nums==null) return nums;
        Map<Integer,Integer> newnums = new HashMap<Integer,Integer>();
        int[] rtr = new int[2];
        for(int i=0;i<nums.length;i++){
            if(newnums.containsKey(target-nums[i])){
                rtr[0] = newnums.get(target-nums[i])+1;
                rtr[1] = i+1;
                return rtr; 
            }
            newnums.put(nums[i],i);
        }
        return rtr;
        
    }

	//	If the input is a stream, how to do that?
	//	(external sort, and then use two pointers from two sides)
			 
	//	Three Sum
	  public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);
	        int len = nums.length;
	        for(int i=0;i<len-2;i++){
	        	//avoid useless increase
	        	if(i==0 || (i>0 && nums[i]!=nums[i-1])){
	        		int lo = i+1; 
	        		int hi = len-1;
	        		int need = 0-nums[i];
	        		while(lo<hi){
	        			if(nums[lo]+nums[hi]==need){
	        				List<Integer> temp = Arrays.asList(nums[i],nums[lo],nums[hi]);
	        				if(result.contains(temp)==false){
	        					result.add(temp);
	        				}
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
	        }
	        return result;
	    }

	  //Three Sum closet
	  public int threeSumClosest(int[] num, int target) {
	    	if(num == null || num.length==0){
				return 0;
			}
	        //sort array
			Arrays.sort(num);
			int len = num.length;
			int res = Integer.MAX_VALUE/2;


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