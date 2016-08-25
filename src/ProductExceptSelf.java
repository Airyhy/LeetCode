//Input: array of integers (example: [5, 10, 2, 3])
//Output: array of integers, multiple all the numbers, except that index (example: [60, 30, 150, 100])
//http://blog.csdn.net/wzy_1988/article/details/46916179

public class ProductExceptSelf{
public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pSeq = new int[nums.length];
        int[] nSeq = new int[nums.length];

        pSeq[0] = 1;
        for (int i = 1; i < len; i ++) {
            pSeq[i] = pSeq[i - 1] * nums[i - 1];
        }

        nSeq[len - 1] = 1;
        for (int i = len - 2; i >= 0; i --) {
            nSeq[i] = nSeq[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i ++) {
            pSeq[i] *= nSeq[i];
        }

        return pSeq;
    }
}