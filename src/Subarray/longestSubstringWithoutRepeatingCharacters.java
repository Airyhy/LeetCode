package Subarray;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 "pwke" is a subsequence and not a substring.
 */
public class longestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s==null || s.length()==0){
            return 0;
        }

        int i=0, maxlen=0;
        Set<Character> cset = new HashSet<>();
        char[] str = s.toCharArray();
        for(int j=0; j<str.length; j++){

            while(cset.contains(str[j])){
                cset.remove(str[i]);
                i++;
            }
            cset.add(str[j]);
            maxlen = Math.max(maxlen,cset.size());
        }
        return maxlen;
    }

}
