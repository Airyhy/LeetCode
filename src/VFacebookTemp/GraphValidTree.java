package VFacebookTemp;

import java.util.*;

/**
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

 Hint:

 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 According to the definition of tree on Wikipedia:
 “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 In other words, any connected graph without simple cycles is a tree.”

 Note: you can assume that no duplicate edges will appear in edges.
 Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */

public class GraphValidTree {


    //BFS
    public boolean validTree1(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }


        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int v = q.poll(), par = 0;
            for (int nb : adj[v]) {
                if (visit[nb]) {
                    par++;
                    if(par>1){
                        return false;
                    }
                }
                else {
                    q.offer(nb);
                }
            }
            visit[v] = true;
        }

        // Check if disjoint vertex
        for (boolean vis : visit)
            if (!vis) return false;
        return true;
    }


    //DFS
    public boolean validTree2(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);

        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());

        // add edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;

        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    // check if an undirected graph has cycle started from vertex u
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);

            if (visited[v] && parent != v){
                return true;
            }
            if (!visited[v] && hasCycle(adjList, v, visited, u)){
                return true;
            }
        }

        return false;
    }




    //Union Find
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
