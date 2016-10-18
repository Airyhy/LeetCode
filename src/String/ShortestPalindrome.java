package String;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.

 For example:
 Given "aacecaaa", return "aaacecaaa".
 Given "abcd", return "dcbabcd".

 */
public class ShortestPalindrome {


    /**
     * The key point is to find the longest palindrome starting from the first character,
     * and then reverse the remaining part as the prefix to s. Any advice will be welcome!
     */
    public String shortestPalindrome(String s) {
        int i = 0, end = s.length() - 1, j = end; char chs[] = s.toCharArray();
        while(i < j) {
            if (chs[i] == chs[j]) {
                i++; j--;
            } else {
                i = 0; end--; j = end;
            }
        }
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;

    }

}
