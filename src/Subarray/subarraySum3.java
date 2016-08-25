package Subarray;

public class subarraySum3 {

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
