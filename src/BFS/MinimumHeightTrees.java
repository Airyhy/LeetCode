package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For a undirected graph with tree characteristics,
 * we can choose any node as the root. The result graph is then a rooted tree.
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 *
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1.
 You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges.
 Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);

        List<List<Integer>> conn = new ArrayList<List<Integer>>();
        List<Integer> ends = new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            conn.add(new ArrayList<Integer>());
        }
        for(int [] pair : edges){
            conn.get(pair[0]).add(pair[1]);
            conn.get(pair[1]).add(pair[0]);
        }

        for(int i=0;i<n;i++){
            if(conn.get(i).size()==1){
                ends.add(i);
            }
        }
        while(n>2){
            n = n - ends.size();
            List<Integer> newends = new ArrayList<Integer>();
            for(Integer i: ends){
                int j = conn.get(i).get(0);
                conn.get(j).remove(i);
                if (conn.get(j).size() == 1) newends.add(j);

            }
            ends = newends;
        }

        return ends;
    }

}
