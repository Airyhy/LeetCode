package VFacebookTemp;

import java.util.Stack;

/**
 *
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 click to show corner cases.

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".

 */
public class SimplifyPath {



    public String simplifyPath(String path) {

        String[] parts = path.split("/");
        Stack<String> st = new Stack<String>();

        for(String part : parts){
            if(part.equals(".") || part.length()==0) continue;
            else if(part.equals("..") ){
                if( st.empty()==false)
                    st.pop();
            }
            else{
                st.push(part);
            }
        }
        if(st.empty()==true){
            return "/";
        }

        StringBuffer sb = new StringBuffer();
        while(st.empty()==false){
            sb.insert(0,"/"+st.pop());
        }
        return sb.toString();
    }
}
