package Subarray;

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
