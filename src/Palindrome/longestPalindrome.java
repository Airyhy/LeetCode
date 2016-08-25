package Palindrome;

public class longestPalindrome {

    /**
     * O(n^2) Time, O(1) Space
     * Expand from center character and center of two chars
     * Update result according to the returned length
     */
    public String longestPalindrome(String s) {
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
}
