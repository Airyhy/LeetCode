import java.util.Arrays;

//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc",
//which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


public class LongestSubstringWithoutRepeatChar{
	public static void main(String[] args){
         System.out.println(lengthOfLongestSubstring("geeksforgeeks"));
	}

	 public int lengthOfLongestSubstring(String s) {
	        if(s==null || s.length()==0 )
	            return 0;
	            
	        int len = s.length();
	        int[] index = new int[256];
	        Arrays.fill(index,-1);
	        char[] str = s.toCharArray();
	        index[str[0]] = 0;
	        int maxlen = 1;
	        int templen = 1;
	        
	        for(int i=1;i<len;i++){
	            char ch = str[i];
	            int pre = index[ch];
	            if(pre == -1 || (i-templen>pre) ){
	                templen++;
	            }else{
	                maxlen = Math.max(maxlen,templen);
	                templen = i - pre; 
	            }
	            index[ch] = i;
	        }
	        maxlen = Math.max(maxlen,templen);
	        return maxlen;
	    }
}