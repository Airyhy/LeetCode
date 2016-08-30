package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

 Example
 X X X X
 X O O X
 X X O X
 X O X X
 After capture all regions surrounded by 'X', the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */

public class SurroundedRegions {

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    Queue<Integer> qx = new LinkedList<Integer>();
    Queue<Integer> qy = new LinkedList<Integer>();

    int row;
    int col;

    public void BFS(int i, int j, char[][] board){
        board[i][j] = 'Y';
        for(int m=0;m<dx.length;m++){
            int newi = i + dx[m];
            int newj = j + dy[m];
            if(newi>=0 && newi<row && newj>=0 && newj<col && board[newi][newj]=='O'){
                qx.add(newi);
                qy.add(newj);
            }
        }
    }

    public void reset(char[][] board){

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='Y'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void surroundedRegions(char[][] board) {
        if(board==null || board.length<2 || board[0].length<2){
            return;
        }
        row = board.length;
        col = board[0].length;

        for(int i=0; i<row; i++){
            if(board[i][0]=='O'){
                qx.add(i);
                qy.add(0);
            }
            if(board[i][col-1]=='O'){
                qx.add(i);
                qy.add(col-1);
            }
        }

        for(int j=0; j<col; j++){
            if(board[0][j]=='O'){
                qx.add(0);
                qy.add(j);
            }
            if(board[row-1][j]=='O'){
                qx.add(row-1);
                qy.add(j);
            }
        }

        while(qx.size()!=0){
            BFS(qx.poll(),qy.poll(),board);
        }

        reset(board);
        return;
    }
}
