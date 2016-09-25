package VFacebookTemp;

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

}
