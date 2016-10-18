package Array;
/**
 *
 * Given an input string, write a function that returns the Run Length Encoded string for the input string.

 For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.

 Algorithm:
 a) Pick the first character from source string.
 b) Append the picked character to the destination string.
 c) Count the number of subsequent occurrences of the picked character and append the count to destination string.
 d) Pick the next character and repeat steps b) c) and d) if end of string is NOT reached.

 */

import java.util.*;
public class NumberAndLength
{

	//	“wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″
	public static ArrayList<Integer> encodeLength(int[] arr){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(arr==null || arr.length==0){
			return res;
		}
		
		int len = arr.length;
		int curr = arr[0];
		res.add(curr);
		int freq = 1;
		for(int i=1; i<len; i++){
			if(arr[i] == curr){
				freq ++;
			}else{
				curr = arr[i];
				res.add(freq);
				res.add(curr);
				freq = 1;
			}

		}
		res.add(freq);
		return res;

	}

}