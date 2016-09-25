package VFacebookTemp;

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

    public int romanToInt(String s) {
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
}
