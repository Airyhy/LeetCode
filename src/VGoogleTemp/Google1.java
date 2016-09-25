package VGoogleTemp;

import java.util.*;

/**
 * You are given an integer X.
 * You must choose two adjacent digits and replace them with the larger of these two digits.
 * For example, from the integer X = 233614, you can obtain: 33614 (by replacing 23 with 3);
 * 23614 (by replacing 33 with 3 or 36 with 6);
 * 23364 (by replacing 61 with 6 or 14 with 4);
 *
 * You want to find the smallest number that can be obtained from X by replacing
 * two adjacent digits with the larger of the two.
 *
 * In the above example, the smallest such number is 23364.
 * Write a function: class Solution { public int solution(int X); } that,
 * given a positive integer X, returns the smallest number that can be obtained from X
 * by replacing two adjacent digits with the larger of the two.
 *
 * For example, given X = 233614, the function should return 23364, as explained above.
 * Assume that: X is an integer within the range[10..1,000,000,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

 链接: https://instant.1point3acres.com/thread/185211
 来源: 一亩三分地
 */
public  class Google1 {

    public static int solution1(int X)
    {
        String number = Integer.toString(X);
        int len = number.length();
        if (number.length() == 1) return X;



        int max = -1;
        for (int i = 0; i < len - 1; i++)
        {
            int  left = Integer.parseInt(number.substring(i,i+1));
            int  right = Integer.parseInt(number.substring(i+1,i+2));

            StringBuffer sb = new StringBuffer();


            int mean = (int)Math.ceil( ((float)left+right )/2);
            sb.append(number.substring(0,i)).append(mean).append(number.substring(i+2));

            int newMax = Integer.parseInt(sb.toString());
            max = Math.max(max,newMax);
        }
        return max;
    }

    public static int solution(int X)
    {
        String number = Integer.toString(X);
        int len = number.length();
        if (number.length() == 1) return X;


        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len - 1; i++)
        {
            int  left = Integer.parseInt(number.substring(i,i+1));
            int  right = Integer.parseInt(number.substring(i+1,i+2));

            if ( left >= right ){
                    continue;
            } else {
                if ( i>0 ){
                    int xleft =  Integer.parseInt(number.substring(i-1,i));
                    if( xleft == left || xleft - 1 == left){
                        sb.append(number.substring(0,i)).append(number.substring(i+1));
                        break;
                    }
                } else {
                    int mean = (int)Math.ceil( ((float)left+right )/2);
                    sb.append(number.substring(0,i)).append(mean).append(number.substring(i+2));
                    break;
                }
            }
        }
        if( sb.length()==0) {
            int left =  Integer.parseInt(number.substring(len-1,len));
            int right = Integer.parseInt(number.substring(len-2,len-1));
            int mean = (int)Math.ceil( ((float)left+right )/2);
            sb.append(number.substring(0,len-2)).append(mean);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String args[]){
        System.out.println(solution(1000));
        System.out.println(solution(1000));

        System.out.println(solution(22222228));
        System.out.println(solution(22222228));

        System.out.println(solution(12345));
        System.out.println(solution1(12345));
        System.out.println(solution(62215));
        System.out.println(solution1(62215));
        System.out.println(solution(23));
        System.out.println(solution1(23));
        System.out.println(solution(8));
        System.out.println(solution1(8));
    }
}
