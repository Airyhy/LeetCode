package Array;

/**
 * Given an integer array, find a subarray where the sum of numbers is in a given interval.
 * Your code should return the number of possible answers. (The element in the array should be positive)

 Have you met this question in a real interview? Yes
 Example
 Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:

 [0, 0]
 [0, 1]
 [1, 1]
 [2, 2]
 */
public class subarraySum2 {

    public int subarraySumII(int[] A, int start, int end) {
        int len = A.length;
        int[] sum = new int[len+1];
        int rst = 0;
        //pre-compute for the sum
        for(int i=0;i<len;i++){
            sum[i+1] = sum[i] + A[i];
        }

        //find diff of the sums
        for(int i=0; i<len; i++){
            for(int j=i+1; j<=len; j++){
                int diff = sum[j] - sum[i];
                if(diff>=start && diff<=end){
                    rst++;
                }
            }
        }
        return rst;
    }

}
