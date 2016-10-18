package VFacebookTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string source and a string target,
 * find the minimum window in source which will contain all the characters in target.

 Notice

 If there is no such window in source that covers all characters in target, return the emtpy string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

 Example
 For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"
 */
public class MinimumWindowSubstring {



    public String minWindow1(String s, String t) {
        if(s==null || t==null || s.length()<t.length() || t.length()==0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        int count = t.length();
        int i = 0, j = 0;
        char[] arr = s.toCharArray();
        String res = "";
        int len = Integer.MAX_VALUE;
        while(j<arr.length){
            if(map.containsKey(arr[j])){
                if(map.get(arr[j])>0) count--;
                map.put(arr[j], map.get(arr[j])-1);
            }
            while(count==0){
                if(len>j-i+1) {
                    len = j-i+1;
                    res = s.substring(i,j+1);
                }
                if(map.containsKey(arr[i])){
                    if(map.get(arr[i])==0) count++;
                    map.put(arr[i], map.get(arr[i])+1);
                }
                i++;
            }
            j++;
        }
        return res;
    }



    public String minWindow(String source, String target) {
        // write your code

        int[] cnt = new int[256];

        for( char c : target.toCharArray()){
            cnt[c]--;
        }

        int targetlen = target.length();
        int windowlen = Integer.MAX_VALUE;
        int j=0;
        String window = "";

        for(int i=0;i<source.length();i++){
            char c = source.charAt(i);
            if(cnt[c] < 0) {
                targetlen--;
            }
            cnt[c]++;

            while(targetlen==0){
                if(i-j+1<windowlen){
                    windowlen = i-j+1;
                    window = source.substring(j,i+1);
                }

                //slow foward, the count reduces
                cnt[source.charAt(j)]--;
                if( cnt[source.charAt(j)]<0){
                    targetlen++;
                }

                j++;
            }
        }
        return window;
    }



}
