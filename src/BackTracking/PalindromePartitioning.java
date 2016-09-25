package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]

 */
public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        recurs(new ArrayList<>(), s, 0);
        return result;
    }

    public void recurs(List<String> entry, String s, int start){
        if(start == s.length()) {
            result.add(new ArrayList<>(entry));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                List<String> newentry = new ArrayList<>(entry);

                newentry.add(s.substring(start, i + 1));
                recurs(newentry, s, i + 1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

}
