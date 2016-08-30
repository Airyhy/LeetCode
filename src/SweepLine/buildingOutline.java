package SweepLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given N buildings in a x-axis，
 * each building is a rectangle and can be represented by a triple (start, end, height)，
 * where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building.
 * Buildings may overlap if you see them from far away，find the outline of them。

 An outline can be represented by a triple, (start, end, height),
 where start is the start position on x-axis of the outline,
 end is the end position on x-axis and height is the height of the outline.

 Given 3 buildings：

 [
 [1, 3, 3],
 [2, 4, 4],
 [5, 6, 1]
 ]
 The outlines are：

 [
 [1, 2, 3],
 [2, 4, 4],
 [5, 6, 1]
 ]

 */
public class buildingOutline {


    public class Edge{
        int x;
        boolean isStart;
        int h;
        public Edge(int _x, boolean is, int _h){
            x = _x;
            isStart = is;
            h = _h;
        }
    }

    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        if(buildings==null || buildings.length==0){
            return rst;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        PriorityQueue<Integer> heights = new PriorityQueue<>(10, Collections.reverseOrder());
        for(int[] one : buildings){
            edges.add(new Edge(one[0],true,one[2]));
            edges.add(new Edge(one[1],false,one[2]));
        }
        //shit stupid question
        Collections.sort(edges, new Comparator<Edge>(){
            public int compare(Edge b1, Edge b2){
                if(b1.x!=b2.x){
                    return b1.x - b2.x;
                } else if(b1.isStart && b2.isStart){
                    return b2.h - b1.h;
                } else if(!b1.isStart && !b2.isStart){
                    return b1.h - b2.h;
                } else if(b1.isStart){
                    return -1;
                } return 1;

            }
        });

        ArrayList<Integer> otl = new ArrayList<>();
        for(Edge e : edges){
            if(otl.size()==0){
                heights.add(e.h);
                otl.add(e.x);
                continue;
            }
            if(e.isStart==true){

                int hi = heights.peek();

                heights.add(e.h);
                if(e.h>hi){
                    otl.add(e.x);
                    otl.add(hi);
                    rst.add(otl);
                    otl = new ArrayList<>();
                    otl.add(e.x);
                }
            }else{
                heights.remove(e.h);
                if(heights.size()==0){
                    otl.add(e.x);
                    otl.add(e.h);
                    rst.add(otl);
                    otl = new ArrayList<>();
                    continue;
                }
                int hi = heights.peek();

                if(e.h>hi){
                    otl.add(e.x);
                    otl.add(e.h);
                    rst.add(otl);
                    otl = new ArrayList<>();
                    otl.add(e.x);
                }
            }

        }
        return rst;
    }

}
