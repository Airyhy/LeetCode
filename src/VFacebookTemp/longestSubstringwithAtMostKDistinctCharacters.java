package VFacebookTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = "eceba", k = 3,

 T is "eceb" which its length is 4.
 */
public class longestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        // 2 pointers
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {

            // go fast until meet a problem

            while (j < s.length()) {
                char fast = s.charAt(j);

                if (map.containsKey(fast)) {
                    map.put(fast, map.get(fast) + 1);
                } else {
                    if(map.size() == k){
                        break;
                    }
                    map.put(fast, 1);
                }
                j++;
            }

            maxLen = Math.max(maxLen, j - i);
            char slow = s.charAt(i);

            // clean up the problem

            if(map.containsKey(slow)){
                int count = map.get(slow);
                if (count > 1) {
                    map.put(slow, count - 1);
                } else {
                    map.remove(slow);
                }
            }
        }
        return maxLen;
    }

}
