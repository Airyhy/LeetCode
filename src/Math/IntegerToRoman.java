package Math;

/**
 * Given an integer, convert it to a roman numeral.

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
public class IntegerToRoman {

    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }


    public String intToRoman1(int num) {
        String data[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1}, base = -1;
        StringBuilder result = new StringBuilder();

        for(int i = 0;i < data.length;i++){
            if((base=num/value[i])!=0){
                while(base!=0) {
                    result.append(data[i]);
                    base--;
                }
                num=num%value[i];
            }
        }
        return result.toString();
    }
}
