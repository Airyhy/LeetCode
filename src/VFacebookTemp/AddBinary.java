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
        StringBuffer sb = new StringBuffer();
        int idxa = a.length() - 1;
        int idxb = b.length() - 1;
        int car = 0;

        while(idxa>=0||idxb>=0||car>0){
            int sum = car;
            if(idxa>=0){
                sum += a.charAt(idxa)-'0';
                idxa --;
            }
            if(idxb>=0){
                sum += b.charAt(idxb)-'0';
                idxb--;
            }
            sb.append((sum)%2);
            car = (sum)/2;
        }
        return sb.reverse().toString();
    }
}
