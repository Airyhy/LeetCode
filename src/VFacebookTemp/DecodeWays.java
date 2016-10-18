package VFacebookTemp;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.

 */
public class DecodeWays {

    //请问楼主有*怎么写啊 能详细说说嘛？ 是求*代表的所有可能情况的和吗？
    //我当时说要clarify题意，如果是分割的种类（比如2*2,可以是2,*,2 ; 2*,2; 2, *2)就只是在判断valid的时候改。
    // 如果包含所有*替换的可能性就把*能换成的12345...都算进去。然后他就说ok了。

    public int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)<'1'){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        dp[len-1] = s.charAt(len-1) != '0' ? 1 : 0;

        for (int i = len - 2; i >= 0; i--){
            if(s.charAt(i)=='0') continue;
            if(Integer.parseInt(s.substring(i,i+2))<=26){
                dp[i] = dp[i+1] + dp[i+2];
            }else{
                dp[i] = dp[i+1];
            }

        }

        return dp[0];
    }
}
