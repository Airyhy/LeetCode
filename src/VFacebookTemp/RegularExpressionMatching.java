package VFacebookTemp;

/**
 Implement regular expression matching with support for '.' and '*'.
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).
 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true

 */
public class RegularExpressionMatching {
    /**

     1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     3, If p.charAt(j) == '*':
     here are two sub conditions:
     1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
     or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty

     */

    public boolean isMatch(String s, String p) {
        if((s==null || s.length()==0) && (p==null || p.length()==0) ){
            return true;
        }


        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for(int j=1; j<=p.length(); j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1] || dp[0][j-2];
            }
        }

        for(int i=1; i<=s.length(); i++){
            for( int j=1; j<=p.length(); j++){
                if(p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)=='.' || p.charAt(j-2)==s.charAt(i-1)){
                        dp[i][j] = (dp[i][j-1] || dp[i][j-2] || dp[i-1][j] );
                    } else{
                        dp[i][j] = dp[i][j-2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }



    //worst case:
    //http://stackoverflow.com/questions/5892115/whats-the-time-complexity-of-average-regex-algorithms
    //https://swtch.com/~rsc/regexp/regexp1.html
    public boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {return s.isEmpty();}

        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        //P.length() >= 2  or   "*" but the first character equals
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {return true;}
            s = s.substring(1);
        }

        //P.length() >= 2  or   "*" but the first character not equals
        return isMatch(s, p.substring(2));

    }

}
