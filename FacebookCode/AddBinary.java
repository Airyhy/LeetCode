/**
 * Created by Christina on 1/27/16.
 */
public class AddBinary {

    /**
     * add from the end to the begin one by one
     * use c to keep track of if the answer is lager than 1
     * then put the answer to the stringbuilder
     * test case: 无进位, 有进位, 长度差很多
     * */
    //binary
    //O(n), O(n)
    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aa.length || i < bb.length; i++) {
            int digit_a = i < aa.length ? aa[aa.length - i - 1] - '0' : 0;
            int digit_b = i < bb.length ? bb[bb.length - i - 1] - '0' : 0;
            int sum = digit_a + digit_b + c;
            if (sum > 1) {
                sb.append(sum & 1);
                c = 1;
            } else {
                sb.append(sum);
                c = 0;
            }
        }
        if (c != 0) sb.append(c);
        return sb.reverse().toString();
    }

    public static void main(String[] arg) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("1010", "1011"));
        System.out.println(a.addBinary("11", "1"));
    }

}
