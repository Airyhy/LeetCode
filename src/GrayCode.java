//The gray code is a binary numeral system where two successive values differ in only one bit.
//Given a non-negative integer n representing the total number of bits in the code, 
//print the sequence of gray code. A gray code sequence must begin with 0.
//For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//Note:
//For a given n, a gray code sequence is not uniquely defined.
//
//For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
//
//思路：利用位运算，将当前结果中的所有数最前面添上一个1，直到达到n位位置。时间复杂度O(n)
public class GrayCode {
    public List<Integer> grayCode(int n) {

        List<Integer> ret = new ArrayList();
        ret.add(0);

        if (n == 0) return ret;
        int offset = 1;

        for (int i = 0; i < n; i++) {
            for (int j = ret.size() - 1; j >= 0; j--)
                ret.add(ret.get(j) | offset);
            offset = offset << 1;
        }
        return ret;
    }
}