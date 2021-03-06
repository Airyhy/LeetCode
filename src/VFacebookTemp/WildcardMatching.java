package VFacebookTemp;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {

    /**
     * DP solution
     */
    public boolean isMatch(String s, String p) {
        if((s==null || s.length()==0) && (p==null || p.length()==0) ){
            return true;
        }


        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for(int j=1; j<=p.length(); j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1; i<=s.length(); i++){
            for( int j=1; j<=p.length(); j++){
                if(p.charAt(j-1)=='?' || p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    /**
        Liner solution
     */
    boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
