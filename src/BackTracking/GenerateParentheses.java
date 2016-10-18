package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> pa = new ArrayList<String>();
        add(pa,"",n,0);
        return pa;
    }

    public void add(List<String> pa, String str, int n, int m){
        if(m==0&&n==0){
            pa.add(str);
            return;
        }
        if(m>0) {add(pa,str+")",n,m-1); }
        if(n>0) {add(pa,str+"(",n-1,m+1); }
    }

}
