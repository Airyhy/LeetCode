package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1,
 * compute how much water it is able to trap after raining.

 Have you met this question in a real interview? Yes
 Example
 Given 5*4 matrix

 [12,13,0,12]
 [13,4,13,12]
 [13,8,10,12]
 [12,13,12,12]
 [13,13,13,13]

 return 14.
 */
public class trapRainWater2 {

    public class Cell{
        int x;
        int y;
        int h;

        public Cell(int _x, int _y, int _h){
            x = _x;
            y = _y;
            h = _h;
        }
    }

    public int trapRainWater(int[][] heights) {
        // write your code here
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int cnt = 0;
        if (heights==null || heights.length<3 || heights[0]==null || heights[0].length<3){
            return cnt;
        }

        PriorityQueue<Cell> q =  new PriorityQueue<Cell>(20,new Comparator<Cell>(){
            public int compare(Cell c1, Cell c2){
                return c1.h - c2.h;
            }
        });

        int m = heights.length, n = heights[0].length;
        boolean visited[][] = new boolean[m][n];

        for(int i=0;i<n;i++){
            q.add(new Cell(0,i,heights[0][i]));
            q.add(new Cell(m-1,i,heights[m-1][i]));
            visited[0][i]=true;
            visited[m-1][i]=true;
        }

        for(int j=1;j<m-1;j++){
            q.add(new Cell(j,0,heights[j][0]));
            q.add(new Cell(j,n-1,heights[j][n-1]));
            visited[j][0]=true;
            visited[j][n-1]=true;
        }

        while(q.size()!=0){
            Cell cur = q.poll();
            for(int i = 0; i < 4; i++) {

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(0<=nx && nx < m && 0 <= ny && ny < n && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    q.offer(new Cell(nx,ny,Math.max(cur.h,heights[nx][ny])));
                    cnt = cnt + Math.max(0,cur.h - heights[nx][ny]);
                }

            }

        }

        return cnt;
    }
}
