package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haoyangyuan on 8/29/16.
 */
public class numberOfIslands2 {

    public int converttoId( int i, int j,int m){
        return i*m+j;
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        if(operators == null) {
            return ans;
        }

        int[] dx = {0,-1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int[][] island = new int[n][m];

        UnionFind uf = new UnionFind(n, m);
        int count = 0;

        for(Point p : operators){
            count++;
            int i = p.x;
            int j = p.y;

            island[i][j] = 1;
            int id = converttoId(i,j,m);
            for( int k=0; k<4;k++){
                int newi = dx[k] + i;
                int newj = dy[k] + j;
                if(newi>=0 && newi<n && newj>=0 && newj<m){
                    if(island[newi][newj]==1){

                        int newid = converttoId(newi,newj,m);
                        if(uf.compressed_find(id)!=uf.compressed_find(newid)){
                            count--;
                            uf.union(id,newid);
                        }
                    }
                }

            }
            // System.out.println(count);
            ans.add(count);
        }
        return ans;
    }


    class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
    }


    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int n, int m){
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < m; j++) {
                    int id = converttoId(i,j,m);
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
