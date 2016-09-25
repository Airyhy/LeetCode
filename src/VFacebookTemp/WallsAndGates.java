package VFacebookTemp;

import java.util.LinkedList;
import java.util.Queue;

/**

 You are given a m x n 2D grid initialized with these three possible values.

 -1  - A wall or an obstacle.
 0   - A gate.
 INF - Infinity means an empty room.

 We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate.
 If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:
 INF   -1   0   INF
 INF   INF  INF  -1
 INF   -1   INF  -1
 0     -1   INF  INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 */

public class WallsAndGates {


    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];

            for(int i=0;i<dx.length;i++){
                int newx = row + dx[i];
                int newy = col + dy[i];
                if(newx>=0 && newx < rooms.length && newy>=0 && newy<rooms[0].length && rooms[newx][newy]>rooms[row][col]+1){
                    rooms[newx][newy] = rooms[row][col]+1;
                    queue.add(new int[]{newx,newy});
                }
            }
        }
        return;
    }

}
