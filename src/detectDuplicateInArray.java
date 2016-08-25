//Remove Duplicate Letters and You must make sure 
//your result is the smallest in lexicographical order among all possible results.
//https://leetcode.com/problems/remove-duplicate-letters/

   public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
    
        //count all the chars for their positions
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        
        //find the existing smallest char
         for (int i = 0; i < s.length(); i++){
             //1 find the smallest char
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            //2 find the char that is going to eliminate
            cnt[s.charAt(i) - 'a']--;
            if (cnt[s.charAt(i) - 'a'] == 0) 
                break;
        }
        //the end of recursive
        if(s.length()==0){
            return "";
        }
        //the start of recursive
        else{
            return  s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+ s.charAt(pos),""));
        }
    }

//detect duplicate in array
//0 < arr[i] <= length for all and 0 <= i < length
//brute-force
//sort and check
//hashtable
//bit manipulation


public class detectDuplicateInArray{
	public static void main(String[] args){
		int[] test = new int[]{0,3,2,2};
		System.out.println(hasDuplicate(test));

	}

	public static boolean hasDuplicate(int[] arr){
		int check = 0;
		int len = arr.length;
		for(int i=0; i<len; i++){
			check ^= arr[i] ^ i; 
		}
		return check!=0;
	}
}