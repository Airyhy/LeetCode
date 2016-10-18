/**
 * Created by Christina on 2/25/16.
 */
public class AddString {
    /**
     * add from the end to the begin one by one
     * use c to keep track of if the answer is lager than 10
     * then put the answer to the stringbuilder
     * test case: 无进位, 有进位, 长度差很多
     * */
    public String addString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int c = 0;
        int p1 = c1.length - 1, p2 = c2.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            int num1 = p1 >= 0 ? c1[p1--] - '0' : 0;
            int num2 = p2 >= 0 ? c2[p2--] - '0' : 0;
            int sum = num1 + num2 + c;
            if (sum < 10) {
                sb.append(sum);
                c = 0;
            } else {
                sb.append(sum - 10);
                c = 1;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] arg) {
        AddString a = new AddString();
        System.out.println(a.addString("1231", "8237"));
        System.out.println(a.addString("19", "8237"));
        System.out.println(a.addString("9", "8237"));
        System.out.println(a.addString("111", "8237"));
    }

}
