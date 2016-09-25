package Array;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits==null || digits.length<1) return digits;

        int car = 1;
        for(int i=digits.length-1;i>=0 && car>0;i--){
            int temp = digits[i];
            digits[i] = (temp+car)%10;
            car = (temp+car)/10;
        }

        if(car==0){
            return digits;
        }

        //copy to the new array if it has a new carry
        int[] result = new int[digits.length+1];
        result[0] = 1;
        for(int i=0; i<digits.length; i++){
            result[i+1] = digits[i];
        }
        return result;
    }

}
