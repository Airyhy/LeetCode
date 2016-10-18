package VFacebookTemp;

/**
 Given a positive integer,
 return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        int temp = 0;
        while(n!=0){
            temp = (n-1) % 26;
            sb.append( (char)('A'+temp) );
            n = (n -1)/26;

        }

        return sb.reverse().toString();
    }
}
