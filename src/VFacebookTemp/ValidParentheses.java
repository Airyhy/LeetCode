package VFacebookTemp;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.

 The brackets must close in the correct order,
 "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s==null || s.length()==0 ) {
            return false;
        }

        char[] chs = s.toCharArray();
        Stack<Character> buf = new Stack<Character>();

        for(char i : chs){
            if(i=='('||i=='['||i=='{'){
                buf.push(i);
            }
            else if(i==')'&&buf.empty()==false&&buf.peek()=='('){
                buf.pop();
                continue;
            }
            else if(i==']'&&buf.empty()==false&&buf.peek()=='['){
                buf.pop();
                continue;
            }
            else if(i=='}'&&buf.empty()==false&&buf.peek()=='{'){
                buf.pop();
                continue;
            }
            else return false;
        }
        return buf.empty();
    }

}
