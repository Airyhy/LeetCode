package String;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {

    public String vows = "aeiouAEIOU";

    public String reverseVowels(String s) {

        char[] list=s.toCharArray();

        for(int i=0,j=list.length-1;i<j;){
            if(vows.indexOf(list[i])==-1){
                i++;
                continue;
            }
            if(vows.indexOf(list[j])==-1){
                j--;
                continue;
            }
            char temp=list[i];
            list[i]=list[j];
            list[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(list);
    }

}
