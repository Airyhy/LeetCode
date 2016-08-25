package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallestMatrix {
    public int[] dx = {0,0,1,-1};
    public int[] dy = {1,-1,0,0};

    public class node{
        int x;
        int y;
        int val;

        public node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public boolean isValid(boolean[][] visited, int x, int y){
        if( x >=0 && x < visited.length && y >=0 && y< visited[0].length && visited[x][y]==false){
            return true;
        }
        return false;
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        if (matrix.length * matrix[0].length < k) {
            return -1;
        }

        int row = matrix.length, col = matrix[0].length;
        PriorityQueue<node> heap = new PriorityQueue<node>(k, new Comparator<node>() {
            @Override
            public int compare(node n1, node n2) {
                return n1.val - n2.val;
            }
        });

        boolean[][] visited = new boolean[row][col];
        heap.add(new node(0,0,matrix[0][0]));
        visited[0][0] = true;

        while(k>1){
            node temp = heap.poll();
            k--;
            for(int i=0; i<dx.length; i++){
                int newx = temp.x+dx[i];
                int newy = temp.y+dy[i];
                if( isValid(visited,newx,newy)){
                    int val = matrix[newx][newy];
                    visited[newx][newy] = true;
                    heap.add(new node(newx,newy,val));
                }
            }
        }
        return heap.poll().val;
    }
}
