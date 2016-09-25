package VFacebookTemp;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class Sqrt {


    /**
     * Binary Search
     */
    public int mySqrt(int x) {

        if (x == 0){
            return 0;
        }

        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else if ( (mid + 1) > x/(mid+1) ){
                return mid;
            }
            else{
                left = mid + 1;

            }
        }
    }

    /**
     * Newton Method
     * https://zh.wikipedia.org/wiki/%E7%89%9B%E9%A1%BF%E6%B3%95
     * http://www.guokr.com/question/461510/
     */
    public int mySqrt1(int x) {

        if (x == 0){
            return 0;
        }

        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }

}

