package VFacebookTemp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class wordBreak {

    /**
     * DP, 是否可以组合成一个合法字符串,从小到大,美一阶段穷尽搜索
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null||wordDict==null) return false;
        int len = 0;

        boolean[] part = new boolean[s.length()+1];
        part[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i ;j++){
                if(part[j]==true && wordDict.contains(s.substring(j,i))){
                    part[i] = true;
                }
            }
        }
        return part[s.length()];
    }


    /**
     *  DFS
     */
    public boolean wordBreakv(String s, Set<String> wordDict) {
        if(s==null || wordDict==null) return false;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return canBreak(s, wordDict,map);
    }
    private boolean canBreak(String s, Set<String> wordDict, Map<String, Boolean> map){
        if(s.isEmpty()){
            return true;
        }
        if(map.containsKey(s)) return map.get(s);
        for(int j=1;j<=s.length();j++){
            if(wordDict.contains(s.substring(0,j)) && canBreak(s.substring(j),wordDict, map)){
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
