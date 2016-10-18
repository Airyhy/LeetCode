package VFacebookTemp;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {



    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;

        for(int j=0;j<s.length();j++){
            //push )
            if(s.charAt(j)=='(') stack.push(j);
            else {
                //empty node before, invalid, start from j
                if (stack.isEmpty()) left=j;
                else{
                    //pop the result, and recount the length
                    stack.pop();
                    if(stack.isEmpty()) {
                        max=Math.max(max,j-left);
                    }
                    else {
                        max=Math.max(max,j-stack.peek());
                    }
                }
            }
        }
        return max;
    }

}
