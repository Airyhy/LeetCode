
//Given an input string, write a function that returns the Run Length Encoded string for the input string.
//
//For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
//
//Algorithm:
//a) Pick the first character from source string.
//b) Append the picked character to the destination string.
//c) Count the number of subsequent occurrences of the picked character and append the count to destination string.
//d) Pick the next character and repeat steps b) c) and d) if end of string is NOT reached.

// https://leetcode.com/problems/count-and-say/


import java.util.*;
public class NumberAndLength
{
	public static void main(String[] args){
		int[] test = new int[]{1,1,1,1,0,0,1,1,0,1};
		for(int n: encodeLength(test)){
			System.out.print(n);
		}

	}

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
	
//	count and Say
	 public String countAndSay(int n) {
	        StringBuffer start = new StringBuffer(String.valueOf(1));
	        
	        for(int i=0;i<n-1;i++){
	             int[] cont = new int[10];
	             int len = start.length();
	             char temp1 = start.charAt(0), temp2 = 0;
	                
	             for(int j=0;j<len;j++){
	                    
	                    temp2 = start.charAt(j);
	                    
	                    if(temp2==temp1){
	                        cont[temp1-'0']++;
	                    }
	                    else{
	                        start.append(cont[temp1-'0']);
	                        start.append(temp1-'0');
	                        cont[temp1-'0'] = 0;
	                        cont[temp2-'0'] = 1;
	                    }
	                    temp1 = temp2;
	                }
	                start.append(cont[temp1-'0']);
	                start.append(temp1-'0');
	                start.delete(0,len);
	        }
	        return start.toString();
	    }
}