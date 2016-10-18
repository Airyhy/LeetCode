/**
 * Created by Christina on 2/26/16.
 */
public class MultiplyStrings {

    /**
     * multiply each digit in num1 with each one in num2, put the product into the array
     * if the number in array is more than 10, just add the number - 10 into the next digit   from end to the start
     * */
    //len1 * len2
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                product[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = product.length - 1; i >= 0; i--) {
            int sum = c + product[i];
            c = sum / 10;
            product[i] = sum % 10;
            sb.append(product[i]);
        }
        sb = sb.reverse();
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public static void main(String[] arg) {
        MultiplyStrings a = new MultiplyStrings();
        System.out.println(a.multiply("9", "9"));
        System.out.println(a.multiply("0", "123"));
        System.out.println(a.multiply("1", "123"));
        System.out.println(a.multiply("22", "123"));
        System.out.println(a.multiply("34", "123"));
    }
}
