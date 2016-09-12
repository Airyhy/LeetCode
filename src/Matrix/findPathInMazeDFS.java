package Matrix;

/**
 * 2D array m*n, mice at (0,0), somewhere in the matrix has cheese, called 9
 * Is there a way to cheese ? path is 1 in the matrix
 */
public class findPathInMazeDFS {

    public int[] dx = {0,0,1,-1};
    public int[] dy = {1,-1,0,0};

    public int findPathInMaze(int[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return 0;
        }
        if (maze[0][0] == 0) {
            return 0;
        }
        if (maze[0][0] == 9) {
            return 1;
        }
        return dfs(maze, 0, 0) ? 1 : 0;
    }

    private boolean dfs(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[x].length || maze[x][y] == 0) {
            return false;
        }
        if (maze[x][y] == 9) {
            return true;
        }
        else {
            boolean rst = false;
            maze[x][y] = 0;
            for(int j=0; j<dx.length;j++){
                int newx = x + dx[j];
                int newy = y + dy[j];
                rst = rst || dfs(maze, newx, newy);
            }
            return rst;
        }
    }
}
