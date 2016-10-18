package VFacebookTemp;

/**
 Given an array of n positive integers and a positive integer s,
 find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

 Have you met this question in a real interview? Yes
 Example
 Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

 */
public class minimumSizeSubarraySum {



    public int minimumSize(int[] nums, int s) {
        // write your code here
        if( nums==null || nums.length==0 ){
            return -1;
        }

        //创造一个window,一边+,一边-.莤barray

        int j = 0, sum = 0, min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            while( j<nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            if( sum >= s){
                min = Math.min(min, j-i);
            }
            sum -= nums[i];
        }

        if( min== Integer.MAX_VALUE){
            return -1;
        } else {
            return min;
        }
    }



    /**
     * Brute Force
     */
    int smallestSubWithSum(int arr[], int n, int x)
    {
        //  Initilize length of smallest subarray as n+1
        int min_len = n + 1;

        // Pick every element as starting point
        for (int start = 0; start < n; start++)
        {
            // Initialize sum starting with current start
            int curr_sum = arr[start];

            // If first element itself is greater
            if (curr_sum >= x)
                return 1;

            // Try different ending points for curremt start
            for (int end = start + 1; end < n; end++)
            {
                // add last element to current sum
                curr_sum += arr[end];

                // If sum becomes more than x and length of
                // this subarray is smaller than current smallest
                // length, update the smallest length (or result)
                if (curr_sum >= x && (end - start + 1) < min_len)
                    min_len = (end - start + 1);
            }
        }
        return min_len;
    }

    /**
     * 把第一题extend到2D。给一个matrix, all elements are positive，问有没有个sub rectangle加起来和等于target。
     * return true/false。
     Lz听到题目有点懵，认真调整心态，解决之。先写了个cumulative sum。
     把所有从0,0 到i,j的和算在新的matrix的i,j上。方便之后算head到tail的sub rectangle的和。这一步O(n^2)

     submatrixSum
     */


}
