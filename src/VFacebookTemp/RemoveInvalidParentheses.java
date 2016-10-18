package VFacebookTemp;

import java.util.*;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Examples:
 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]
 */
public class RemoveInvalidParentheses {

    /**
     * Give a string, return valid parenthesis with least modification
     */
    public static String removeInvalid(String str) {
        // check edge case
        if (str == null || str.length() == 0) {
            return str;
        }

        // preprocess
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        // main
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    //add all invalid ) to set
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        //add all invalid ( to set
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }

        // reconstruct
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(i)) {
                continue;
            }
            result += ch;
        }
        return result;
    }

    /**
     * DFS answer
     */
    public List<String> removeInvalidParentheses(String s) {
        //get the calculation
        Set<String> result = new HashSet<>();
        int left=0, right=0;

        //left right, at most you should delete number of ( )
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') left++;
            else if(s.charAt(i)==')'){
                if(left!=0) left--;
                else right++;
            }
        }
        recurs(s,result,left,right,0,0,new StringBuffer());
        return new ArrayList<String>(result);
    }

    public void recurs(String s,Set<String> result,int left,int right,int index,int half,StringBuffer sb){

        if(s.length()==index && left==0 && right==0 && half==0){
            result.add(sb.toString());
            return;
        }
        if(s.length()==index || half<0 || left<0 || right<0){
            return;
        }

        char c = s.charAt(index);

        if(c=='('){
            recurs(s,result,left-1,right,index+1,half,new StringBuffer(sb));
            recurs(s,result,left,right,index+1,half+1,new StringBuffer(sb).append(c));
        }
        else if(c==')'){
            recurs(s,result,left,right-1,index+1,half,new StringBuffer(sb));
            recurs(s,result,left,right,index+1,half-1,new StringBuffer(sb).append(c));
        }
        else{
            recurs(s,result,left,right,index+1,half,new StringBuffer(sb).append(c));
        }
        return;
    }


    /**
     * BFS answer
     */
    public List<String> removeInvalidParentheses2(String s) {

        List<String> res = new ArrayList<>();
        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }

    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }

}
