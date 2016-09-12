package Math;

/**
 * 输入是一个int数组，输出是所有int类型的最大公约数。
 我的思路是，一个数组的最大公约数一定是某两个数最大公约数和其他数的最大公约数
 所以求出来前两个的最大公约数，再拿到这个数字和之后所有的数字求最大公约数就是结果

 */
public class GreatestCommonDivisor {

    public static int greatestCommonDivisor(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = gcdOfTwoNumbers(result, array[i]);
            if (result == 0) {
                break;
            }
        }
        return result;
    }

    private static int gcdOfTwoNumbers(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int temp;
        int num1 = Math.max(m,n);
        int num2 = Math.min(m,n);

        while (num1 != 0 && num2 != 0) {
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1 + num2;
    }
}
