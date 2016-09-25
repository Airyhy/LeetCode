package VFacebookTemp;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */

public class groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map= new HashMap();
        Arrays.sort(strs);

        for(String str : strs){

            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String cont = new String(temp);

            if(map.containsKey(cont)==false){
                List<String> one = new ArrayList();
                one.add(str);
                map.put(cont,one);
            }
            else{
                map.get(cont).add(str);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
