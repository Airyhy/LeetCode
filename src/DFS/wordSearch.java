package DFS;

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

    public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0 ){
            return true;
        }
        if(board==null || board[0]==null || board[0].length==0 ){
            return false;
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && DFS(board,i,j,word,0)){
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
        ret = (DFS(board,i-1,j,word,index+1) || DFS(board,i,j-1,word,index+1) ||
                DFS(board,i+1,j,word,index+1) || DFS(board,i,j+1,word,index+1));
        board[i][j] = word.charAt(index);
        return ret;
    }

}
