package VFacebookTemp;

/**
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100"

 */
public class AddBinary {


    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int i = 0, carry = 0;
        String res = "";

        while(i<lena || i<lenb || carry!=0){
            int x = (i<lena) ? a.charAt(lena - 1 - i)-'0' : 0;
            int y = (i<lenb) ? b.charAt(lenb - 1 - i)-'0' : 0;
            res = (x + y + carry)%2 + res;
            carry = (x + y + carry)/2;
            i++;
        }

        return res;
    }


    public String addBinary2(String a, String b) {

        StringBuffer sb = new StringBuffer();
        int idxa = a.length() - 1;
        int idxb = b.length() - 1;
        int car = 0;

        while(idxa>=0||idxb>=0){
            if(idxa<0){
                int temp = b.charAt(idxb)-'0';
                sb.append((temp+car)%2);
                car = (temp + car)/2;
                idxb--;
                continue;
            }
            if(idxb<0){
                int temp = a.charAt(idxa)-'0';
                sb.append((temp+car)%2);
                car = (temp + car)/2;
                idxa--;
                continue;
            }
            int tempa = a.charAt(idxa)-'0';
            int tempb = b.charAt(idxb)-'0';
            sb.append((tempa+tempb+car)%2);
            car = (tempa+tempb+car)/2;
            idxa--;
            idxb--;
            continue;
        }
        if(car==1){ sb.append(1); }
        return sb.reverse().toString();
    }
}
