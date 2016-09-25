package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0
 We return the result as an array: [1, 1, 2, 3]

 Challenge:

 Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class numberOfIslands2 {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> ans = new ArrayList<Integer>();
        if(positions == null) {
            return ans;
        }

        int[] dx = {0,-1, 0, 1};
        int[] dy = {1, 0, -1,0};
        int[][] island = new int[m][n];

        UnionFind uf = new UnionFind(m, n);
        int count = 0;

        for(int[] p : positions){
            count++;
            int i = p[0];
            int j = p[1];

            if(i<0 || i>=m || j<0 || j>=n ){
                continue;
            }

            island[i][j] = 1;
            int id = converttoId(i,j,n);
            for( int k=0; k<4;k++){
                int newi = dx[k] + i;
                int newj = dy[k] + j;
                if(newi>=0 && newi<m && newj>=0 && newj<n){
                    if(island[newi][newj]==1){

                        int newid = converttoId(newi,newj,n);
                        if(uf.compressed_find(id)!=uf.compressed_find(newid)){
                            count--;
                            uf.union(id,newid);
                        }
                    }
                }

            }
            ans.add(count);
        }
        return ans;
    }

    public int converttoId( int i, int j, int n){
        return i * n + j;
    }

    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int m, int n){
            for(int i = 0 ; i < m; i++) {
                for(int j = 0 ; j < n; j++) {
                    int id = converttoId(i,j,n);
                    father.put(id, id);
                }
            }
        }
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = x;
            while(fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;

        }

        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
}
