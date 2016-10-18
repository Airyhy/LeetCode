package Math;

import java.util.ArrayList;
import java.util.List;

/**
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?

 Show Tags
 Show Similar Problems

 */
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList();

        for(int i=0;i<=rowIndex;i++){
            result.add(0,1);
            for(int j=1;j<result.size()-1;j++){
                int temp = result.get(j)+result.get(j+1);
                result.set(j,temp);
            }
        }
        return result;
    }

}
