package DFS;

import java.util.*;

/**
 Given a string s and a dictionary of words dict,
 add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreak2 {


    /**
     * divide the word into two parts
     * if the first part is in the wordDict, then recursively use the function
     * to get word break of the next part
     * */
    //backtracking
    //the time complexity is complicated but for the worst case, if every signle character is in
    // the wordDict, it is O(n^2)
    Map<String,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(map.containsKey(s)){
            return map.get(s);
        }

        if (s == null || s.length() == 0) {return new ArrayList<>();}
        List<String> ret = new ArrayList<>();

        for (int i = 1; i < s.length() + 1; i++) {
            String temp = s.substring(0, i);
            if (wordDict.contains(temp)) {
                if (i != s.length()) {
                    List<String> nextList = wordBreak(s.substring(i), wordDict);
                    for (String str : nextList) {
                        ret.add(temp + " " + str);
                    }
                } else {
                    ret.add(temp);
                }
            }
        }

        map.put(s,ret);
        return ret;
    }




    //遍历s
    public List<String> wordBreak2(String s, Set<String> wordDict) {

        return DFS2(s, wordDict, new HashMap<>());
    }

    List<String> DFS2(String s, Set<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> ret = new LinkedList<>();
        if (s.length() == 0) {
            ret.add("");
            return ret;
        }


        for (int i = 1; i < s.length() + 1; i++) {
            String word = s.substring(0, i);
            if (wordDict.contains(word)) {
                List<String> sublist = DFS2(s.substring(i), wordDict, map);
                for (String sub : sublist) {
                    ret.add(word + (sub.length()==0 ? "" : " ") + sub);
                }
            }
        }

        map.put(s, ret);
        return ret;
    }
}
