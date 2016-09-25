package VFacebookTemp;

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

    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null||wordDict==null) return false;
        int len = 0;
        for(String str : wordDict){
            len = Math.max(len,str.length());
        }

        boolean[] part = new boolean[s.length()+1];
        part[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i ;j++){
                if(i-j>len) continue;
                if(part[j]==true && wordDict.contains(s.substring(j,i))){
                    part[i] = true;
                }
            }
        }
        return part[s.length()];
    }

}
