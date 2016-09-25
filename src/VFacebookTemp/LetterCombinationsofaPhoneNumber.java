package VFacebookTemp;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new LinkedList<>();

        if(digits.length()==0) return result;
        result.add(new String());

        for(int i=0;i<digits.length();i++){
            int len = result.size();
            char c = digits.charAt(i);

            for(int j=0;j<len;j++){
                String temp = result.get(0);
                for(char s : mapping[c-'0'].toCharArray()){
                    String temp1 = new String(temp) + s;
                    result.add(temp1);
                }
                result.remove(0);
            }
        }

        return result;
    }


    /**
     *
     */
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations2(String digits) {
        List<String> ret = new LinkedList<String>();
        if(digits == null || digits.length() == 0) return ret;

        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }

}
