package Math;

import java.util.ArrayList;
import java.util.List;

/**
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalTriangle {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        if (numRows<1) return tri;

        for(int i=0;i<numRows;i++){
            List<Integer> li = new ArrayList<Integer>();
            tri.add(li);
        }
        tri.get(0).add(1);


        for(int i=1;i<numRows;i++){
            tri.get(i).add(1);
            for(int j=0;j<i-1;j++){
                int temp = tri.get(i-1).get(j)+tri.get(i-1).get(j+1);
                tri.get(i).add(temp);
            }
            tri.get(i).add(1);
        }
        return tri;
    }
}
