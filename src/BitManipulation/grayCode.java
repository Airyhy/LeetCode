package BitManipulation;


import java.util.ArrayList;
import java.util.List;

public class grayCode {


    /**
     * 是graycode，先将两个数做xor，然后判断是否只有一位是不同的。
     * 只要判断term1和term2是不是连续的gray code。所以比leetcode上简单。
     */
    public static boolean grayCheck(byte term1, byte term2) {
        byte result = (byte) (term1 ^ term2);

        for (int i = 0; i <= 7; i++) {
            byte temp = (byte) (1 << i);

            if (temp == result) {
                return true;
            }
        }

        return false;
    }

    public static boolean grayCheck1(byte term1, byte term2){
        byte x = (byte) (term1 ^ term2);
        int count = 0;

        while (x != 0) {
            x = (byte) (x & (x - 1));
            count++;
        }

        return count == 1;
    }


    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.

     Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

     For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

     00 - 0
     01 - 1
     11 - 3
     10 - 2
     Note:
     For a given n, a gray code sequence is not uniquely defined.

     For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

     For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     */

    public List<Integer> grayCode(int n) {

        List<Integer> ret = new ArrayList();
        ret.add(0);

        if (n == 0) return ret;
        int offset = 1;

        for (int i = 0; i < n; i++)
        {
            for (int j = ret.size() - 1; j >= 0; j--)
                ret.add(ret.get(j) | offset);
            offset = offset << 1;
        }
        return ret;
    }
}
