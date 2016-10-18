package VFacebookTemp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a boolean 2D matrix, find the number of islands.
 * [
 [1, 1, 0, 0, 0],
 [0, 1, 0, 0, 1],
 [0, 0, 0, 1, 1],
 [0, 0, 0, 0, 0],
 [0, 0, 0, 0, 1]
 ]
 */
public class NumberOfIslands {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    //Magic DFS
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if( grid==null ||grid.length==0 || grid[0]==null ||grid[0].length==0 ){
            return 0;
        }

        int cnt = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j] == true){
                    grid[i][j]=false;
                    explore(i,j,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void explore(int i,int j, boolean[][] grid){

        for(int m=0;m<dx.length;m++){
            int newi = i + dx[m];
            int newj = j + dy[m];

            if(0<=newi && newi<grid.length && 0<=newj && newj<grid[0].length){
                if (grid[newi][newj]==true){
                    grid[newi][newj]=false;
                    explore(newi,newj,grid);
                }
            }
        }

    }



    //如果是斜着也可以  加上{-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    //bfs //O(n), 0(n)
    final static int[][] Move = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};


    //O(m * n), space: depends
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    Queue<Integer> que = new LinkedList<>();
                    //marked as visited
                    grid[i][j] = '2';
                    que.add(i * n + j);

                    while (!que.isEmpty()) {
                        int temp = que.poll();
                        for (int[] next : Move) {
                            int nextX = temp / n + next[0], nextY = temp % n + next[1];
                            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || grid[nextX][nextY] != '1') {
                                continue;
                            }
                            que.add(nextX * n + nextY);
                            grid[nextX][nextY] = '2';
                        }
                    }

                }
            }
        }
        return cnt;
    }
}
