package VFacebookTemp;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */
public class CountandSay {


    public String countAndSay(int n) {
        StringBuilder seq = new StringBuilder("1");
        for(int i=1;i<n;i++){
            seq = getNextSeq(seq);
        }
        return seq.toString();
    }

    public StringBuilder getNextSeq(StringBuilder s){
        int count = 1;
        int sLen = s.length();
        StringBuilder res = new StringBuilder("");
        for(int i=1;i<sLen;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            } else {
                res.append(count);
                res.append(s.charAt(i-1));
                count = 1;
            }
        }
        res.append(count);
        res.append(s.charAt(sLen-1));
        return res;
    }

}
