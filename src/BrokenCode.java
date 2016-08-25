//给一个sorted array 0 0 0 1 1 1 1，然后找出第一个1的位置。

public class BrokenCode{
	public static void main(String[] args){
		int[] test = new int[]{0,0,1,1};
		System.out.println(findBroken(test));
	}

	public static int findBroken(int[] arr){
		if(arr.length <= 1){
			return -1;
		}
		if(arr.length == 2){
			return arr[0]!=arr[1] ? 1 : -1;
		}
		return broken(arr, 0, arr.length-1);
	}

	public static int broken(int[] arr, int start, int end){
		if(start <= end){
			int mid = start + (end-start)/2;
			if(arr[mid] != arr[mid-1]){
				return mid;
			}else if(arr[mid] == arr[mid-1]){
				return broken(arr,mid+1,end);
			}else{
				return broken(arr,start,mid-1);
			}
		}
		return -1;

	}
}