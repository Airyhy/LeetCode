package VFacebookTemp;

/**
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad.
 Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        if(n<2){
            return n;
        }

        int low = 1, hi = n;
        while(low+1<hi){
            int mid = (hi - low)/2 + low;
            if(isBadVersion(mid)){
                hi = mid;
            } else {
                low = mid;
            }
        }

        return isBadVersion(low)?low:hi;
    }


    //just for compiler to work
    boolean isBadVersion(int version){
        return false;
    }
}
