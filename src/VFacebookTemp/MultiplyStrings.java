package VFacebookTemp;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:
 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();

        char[] numa1 = num1.toCharArray();
        char[] numa2 = num2.toCharArray();
        int[] rslt = new int[len1+len2];

        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int pos = i+j+1;
                rslt[pos] += (numa1[i]-'0')*(numa2[j]-'0');
                rslt[pos-1] += rslt[pos]/10;
                rslt[pos] = rslt[pos]%10;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<rslt.length;i++){
            if(sb.length()==0 && rslt[i]==0){
                continue;
            }
            sb.append(rslt[i]);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }

}
