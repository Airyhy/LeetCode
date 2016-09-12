package TwoPointer;

import java.util.Arrays;

/**
 * 题目就是一个卡车装两桶，两个桶的重量小于等于某值。
 给了 doulbe[] weights, double capacity, 找出两个最优值加起来小于等于 capacity.
 我的解法就是 sort weights一遍，two pointer 方法做。
 */
public class findTheOptimalWeights {

    public static double[] findTheOptimalWeights(double[] weights, double capacity) {
        if (weights == null || weights.length < 2) {
            return new double[0];
        }

        Arrays.sort(weights);
        double[] result = new double[2];
        double max = Double.MIN_VALUE;

        int left = 0, right = weights.length - 1;

        while (left < right) {
            double sum = weights[left] + weights[right];
            if (sum < capacity) {
                if (max < sum) {
                    max = sum;
                    result[0] = weights[left];
                    result[1] = weights[right];
                }
                left++;
            } else if (sum > capacity){
                right--;
            } else {
                result[0] = weights[left];
                result[1] = weights[right];
                break;
            }
        }

        return result;
    }

}
