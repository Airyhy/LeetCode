package BitManipulation;

import java.util.Arrays;

/**
 * 给一个数组 {0,0,1,1,0,1} 和 一个数字n，flip这个数组n次，
 * flip规则：左右不同的设为1，相同设为0。就是XOR操作。数组头尾（index = -1 or arr.length）
 * 可以当作是0，之前也有哥们遇到此题http://www.1point3acres.com/bbs/thread-138007-1-1.html

 一个八个元素的int array，值为0或者1，每天晚上变一次，怎么变呢。。看两边的元素，如果两边一样，变0，不一样变1。
 最左边和最右边的左边和右边就算做0。举个栗子：00111001，第二天变为01101110（应该没错=。=） 两个参数，一是初始状态，二是总共几晚上

 ps：两端cell两边假设const = 0；

 小example：
 day0:  (0)0,1,1,1(0)
 day1:  (0)1,1,0,1(0)
 day2:  (0)1,1,0,0(0)

 */
public class dayChangeProblem {


    public static int[] day(int[] input, int day) {
        if (day <= 0 || input == null || input.length == 0) {
            return input;
        }

        int[] result = new int[input.length];

        for (int i = 1; i <= day; i++) {

            result = new int[input.length];

            result[0] = (input[1] == 0) ? 0 : 1;
            result[result.length - 1] = (input[input.length - 2] == 0) ? 0 : 1;

            for (int j = 1; j < result.length - 1; j++) {
                result[j] = (input[j - 1] == input[j + 1]) ? 0 : 1;
            }
            input = result;
        }

        return result;
    }


    // bit manipulation in place
    public static int[] day1(int[] input, int day) {
        if (day <= 0 || input == null || input.length == 0) {
            return input;
        }

        for (int i = 1; i <= day; i++) {
            input[0] += (input[1] | 0) == 0 ? 0 : 2;
            input[input.length - 1] += (input[input.length - 2] | 0) == 0 ? 0 : 2;

            for (int j = 1; j < input.length - 1; j++) {
                input[j] += (input[j - 1] & 1) == (input[j + 1] & 1) ? 0 : 2;
            }

            for (int j = 0; j < input.length; j++) {
                input[j] >>= 1;
            }
        }
        return input;
    }
}
