package Map;

import java.util.*;
import java.util.Map.Entry;
public class FirstCharacter{

	/**
	 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

	 Examples:

	 s = "leetcode"
	 return 0.

	 s = "loveleetcode",
	 return 2.
	 Note: You may assume the string contain only lowercase letters.
     */

    public int firstUniqChar(String str) {
		if(str==null || str.length()<1){
			return -1;
		}

		Map<Character,Integer> map = new HashMap<>();
		char[] chars = str.toCharArray();
		for(int i=0; i<chars.length; i++){
			if(map.containsKey(chars[i])){
				map.put(chars[i],map.get(chars[i])+1);
			} else{
				map.put(chars[i],1);
			}
		}

		for(int i=0; i<chars.length; i++){
			if(map.get(chars[i])==1){
				return i;
			}
		}
		return -1;
	}

	/**
	Given a string, find the first repeating character in it and return it's index.
	 If it doesn't exist, return -1.
 	*/

 public static int findDuplicate(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> uniqueChars = new HashMap<Character, Integer> (chars.length, 1);
		for (int i = 0; i < chars.length; i++) {
			Integer previousIndex = uniqueChars.put(chars[i], i);
			if (previousIndex != null) {
				return previousIndex;
			}
		}
		return -1;
	}
}