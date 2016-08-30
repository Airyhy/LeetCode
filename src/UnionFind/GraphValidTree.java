package UnionFind;

import java.util.HashMap;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 */

public class GraphValidTree {


//    这些边是否构成环路，如果有环则不能构成树
//    这些边是否能将所有节点连通，如果有不能连通的节点则不能构成树

    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        int cnt;
        UnionFind(int n){
            for(int i = 0 ; i < n; i++) {
                father.put(i, i);
            }
            cnt = n;
        }

        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = father.get(x);
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
            cnt--;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        UnionFind uf = new UnionFind(n);

        for(int[] edge : edges){
            int src = edge[0];
            int dst = edge[1];

            int srcf = uf.compressed_find(src);
            int dstf = uf.compressed_find(dst);
            if(srcf == dstf){
                return false;
            } else{
                uf.union(src,dst);
            }
        }
        if(uf.cnt==1){
            return true;
        }
        return false;
    }
}
