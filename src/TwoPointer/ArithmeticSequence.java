package TwoPointer;

/**
 * 给一个Array, 返回其中有多少个等差数列子串,子串之间可以叠加
 * [4,5],[4,6]都算,所以需要end-start-2
 */
public class ArithmeticSequence {


    public static int numOfArithmeticSlices(int[] arr) {

        if(arr==null || arr.length < 3){
            return  0;
        }

        int count = 0, start = 0, end = 1, d = 0;

        while (start < arr.length-2) {

            if (start+1 == end) {
                d = arr[end] - arr[start];
                end++;


            } else {
                if (end == arr.length || arr[end] - arr[end-1] != d) {

                    if (end - start >= 3) {
                        count += (end - start - 2);
                    }

                    start++;
                } else

                    end++;
            }
        }
        return count;
    }
}
