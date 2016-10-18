package VFacebookTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Christina on 2/29/16.
 */
public class SparseVectorMultiplication {
    /**
     * iterate the nums1, to put the nonzeroes in the map, key: index, value: value of item
     * iterate the map  then calculate the sum
     *
     * */
    //O(m + n)
    public int sparseVectorMultiplication(int[] nums1, int[] nums2) {
        // nums1.length == nums.length ?
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(i, nums1[i]);
        }
        int ret = 0;
        for (int key : map.keySet()) {
            ret += map.get(key) * nums2[key];
        }
        return ret;
    }


    /**
     *  最后一轮coding也是地里出现过的面经，sparse vector dot multiplication，这道题我当时并没有准备到，
     *  但是正因为如此，我认为我跟面试官的交流给我加分了不少。
     *  面试官首先问我每个vector很大，并不能在内存中存下，该怎么办，我说只需要存下非零的元素和他们的下标就行，
     *  然后询问面试官是否可以用预处理后的这两个vector非零元素的index和value作为输入，
     *  面试官同意后快速写完O(M*N)的代码，M和N分别是两个vector的长度。面试官说这两个输入如果是根据下标排序好的话应该怎么办，
     *  我说可以遍历长度较短的那一个，然后用二分搜索的方法在另一个vector中找index相同的元素，相乘加入到结果中，
     *  这样的话复杂度就是O(M*logN)。
     *  这时，面试官又问是否可以同时利用两个输入都是排序好这一个特性，我在这个地方有点卡住，
     *  但是在白板上写出一个test case，试着用可视化的方法帮助我来进行思考，同时面试官给了一些提醒，
     *  最后写出了O(M + N)的双指针方法，成功结束最后一轮面试。
     sparse vector dot product，what if the number of nonzero elements of one vector is 10^10 and the other is 10^2,
     how can you make it faster?
     我是用的binary search，可以从O(max(m,n))降低到O(n*log(m)), where m = max(m,n)
     */

}
