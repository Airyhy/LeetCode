package VFacebookTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.


 Number	4	9	40	90	400	900
 Notation	IV	IX	XL	XC	CD	CM

 1954 as MCMLIV,
 1990 as MCMXC,
 2014 as MMXIV,

 I placed before V or X indicates one less, so four is IV  nine is IX
 X placed before L or C indicates ten less, so forty is XL and ninety is XC
 C placed before D or M indicates a hundred less, so four hundred is CD and nine hundred is CM
 */
public class RomanToInteger {

    public int romanToInt1(String s) {
        int value = 0;
        char[] str = s.toCharArray();
        char one;
        for(int i = s.length()-1;i>=0;i--){
            one = str[i];
            switch(one){
                case 'I':
                    value = value + (value>=5 ? -1 : 1);
                    break;
                case 'V':
                    value = value + 5;
                    break;
                case 'X':
                    value = value + (value>=50 ? -10 : 10);
                    break;
                case 'L':
                    value = value + 50;
                    break;
                case 'C':
                    value = value + (value>=500?-100:100);
                    break;
                case 'D':
                    value = value + 500;
                    break;
                case 'M':
                    value = value + 1000;
                    break;

            }

        }
        return value;
    }

    /**
     * from the end to the start
     * if the current is smaller than the last  -
     * else +
     *
     * */
    //O(1)
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {return 0;}
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ret = map.get(s.charAt(len - 1));
        int last = ret;
        for (int i = len - 2; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr < last) {
                ret -= curr;
            } else {
                ret += curr;
            }
            last = curr;
        }
        return ret;
    }
}
