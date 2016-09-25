package String;

/**
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

  */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if(s==null || s.length()==0 ){
            return s;
        }
        s = s.trim();
        String[] group = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        
        for(int i=group.length-1;i>=0;i--){
            if(group[i].length()>0){
                sb.append(group[i]);
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
}

