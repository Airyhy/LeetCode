package Matrix;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.
 */

public class GameofLife {

    public void gameOfLife(int[][] board) {
        int[] dx = {0,0,1,-1,1,-1,-1,1};
        int[] dy = {1,-1,0,0,1,-1,1,-1};

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                int check=0;
                for(int k=0;k<dx.length;k++){
                    int newx = dx[k] + i;
                    int newy = dy[k] + j;

                    if(newx>=0 && newx<m && newy>=0 && newy<n ){
                        if (board[newx][newy]==1 || board[newx][newy]==2) check++;
                    }
                }
                if(board[i][j]==1 && (check<2||check>3)) board[i][j]=2;
                if(board[i][j]==0 && check==3) board[i][j]=3;

            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] %= 2;
            }
        }
    }
}
