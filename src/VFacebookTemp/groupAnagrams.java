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

    //O(n), O(n)
    //如果有sort  O(nlogn)
    public List<List<String>> groupAnagrams1(String[] strs) {
        Arrays.sort(strs);
        Map<String, List<String>> map = new HashMap<>();

        for (String s:strs) {
            char[] keyArr = new char[26];
            for (int i = 0; i < s.length(); i++) {
                keyArr[s.charAt(i) - 'a']++;
            }
            String key = new String(keyArr);
            if (!map.containsKey(key)) {map.put(key, new ArrayList<>());}
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }


    //O(n  * len * log(len))
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
