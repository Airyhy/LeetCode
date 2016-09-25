package VFacebookTemp;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
 those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Have you met this question in a real interview? Yes
 Example
 Given board =

 [
 "ABCE",
 "SFCS",
 "ADEE"
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class wordSearch {

    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};

    public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0 ){
            return true;
        }
        if(board==null || board[0]==null || board[0].length==0 ){
            return false;
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(DFS(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, int i, int j, String word, int index){
        if(index==word.length()){
            return true;
        }

        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]!=word.charAt(index)){
            return false;
        }

        board[i][j] = '#';
        boolean ret = false;
        for(int m=0; m<dx.length; m++){
            int newi = i + dx[m];
            int newj = j + dy[m];
            ret = ret || DFS(board,newi,newj,word,index+1);
        }
        board[i][j] = word.charAt(index);
        return ret;
    }

}
