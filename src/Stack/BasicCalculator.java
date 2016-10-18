package Stack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ),
 the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:
 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {


    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] sh = s.toCharArray();

        int result = 0;
        int sign = 1;
        int number = 0;
        for(int i=0;i<sh.length;i++){
            char ch = sh[i];
            if(Character.isDigit(ch)){
                number = 10*number + (int)(ch-'0');
            }
            else if(ch=='+'){

                result = result + sign*number;
                number = 0;
                sign = 1;

            }
            else if(ch=='-'){
                result = result + sign*number;
                number = 0;
                sign = -1;
            }
            else if(ch=='('){
                stack.push(result);

                stack.push(sign);
                sign = 1;
                result = 0;
            }
            else if(ch==')'){

                result = result + sign*number;
                number = 0;
                result = result * stack.pop();
                result = result + stack.pop();
            }
            else continue;
        }
        if(number!=0) result = result + sign*number;
        return result;
    }
}
