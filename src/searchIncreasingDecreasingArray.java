public class searchIncreasingDecreasingArray{
	public static void main(String[] args){
		int[] arr = new int[] {1,3,5,7,19,221,132,56,8,6,4,2,1,-3,-17}; 
		System.out.println(search(arr, 2));

	}


	public static int search(int[] arr, int target){
		int peak = findPeak(arr, 0, arr.length);

		System.out.println("Peak element index: " + peak);

		int res = binarySearch(arr, 0, peak, target, true);
		System.out.println("Search increasing array: " + res);

		if(res != -1){
			return res;
		}else{
			res = binarySearch(arr, peak, arr.length-1, target, false);
			System.out.println("Search decreasing array: " + res);
			return res;
		}

	}

    //find peak element using binary search
	public static int findPeak(int[] arr, int low, int high){
		if(arr.length<=2)
			return -1;
			
		int mid=(low+high)/2;
		
		if(low==mid|| mid+1==high )
			return -1;
		
		if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
			return mid;
		
		if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
		    //increasing slope
		    return findPeak(arr,mid, high);
		}
		if(arr[mid-1]>arr[mid] && arr[mid]>arr[mid+1]){
		    return findPeak(arr,low, mid);
		}
		
		return -1;
	}

	public static int binarySearch(int[] arr, int low, int high, int target, boolean isIncreasing){
		while(low < high - 1){
			int mid = low + (high - low)/2;
			if(arr[mid] == target){
				return mid;
			}else if(arr[mid] < target){
				if(isIncreasing){
					low = mid;
				}else{
					high = mid;
				}
			}else{
				if(isIncreasing){
					high = mid;
				}else{
					low = mid;
				}
			}
		}
		if(arr[low]==target){
			return low;
		}else if(arr[high]==target){
			return high;
		}
		return -1;
	}
}