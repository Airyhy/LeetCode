package Palindrome;

public class LongestPalindromicSubstring {


    /**
     * O(n^2) Time, O(1) Space
     * Expand from center character and center of two chars
     * Update result according to the returned length
     */
    public String longestPalindromeSubstring(String s) {
        if (s == null || s.length() == 0) return "";
        String longest = s.substring(0, 1);
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            String s1 = expandAroundCenter(s, i, i);
            if (s1.length() > longest.length()) longest = s1;
            String s2 = expandAroundCenter(s, i, i + 1);
            if (s2.length() > longest.length()) longest = s2;
        }
        return longest;
    }

    /**
     * Search for range in both direction
     */
    private String expandAroundCenter(String s, int i, int j) {
        int l = i;
        int r = j;
        int n = s.length();
        while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //System.out.println(s.substring(l + 1, r));
        return s.substring(l + 1, r); // note the range is from l + 1 to r - 1
    }


    /**
     * two dimensional DP
     * check the substring(i, j) is palindrome or not
     * just check if charAt(i) == charAt(j) && i == j - 1 or isPalin[i+1][j-1]
     *
     * */
    //O(n^2)

    public String longestPalindrome(String s) {
        s = s.trim();
        if ( s == null || s.length() == 0 ) {return "";}
        String result = "";
        boolean[][] map = new boolean[s.length()][s.length()];
        char[] string_char = s.toCharArray();
        for ( int i = 0; i < s.length(); ++i ) {
            for ( int j = i; j >= 0; --j ) {
                map[j][i] = (string_char[i] == string_char[j] && (( i - j) < 3 || map[j+1][i-1]) );
                if (map[j][i] && ( i - j + 1 ) > result.length() ) {
                    result = s.substring(j, i+1);
                }
            }
        }
        return result;
    }

}
