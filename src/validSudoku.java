/**
* Problem: Determine if a sudoku if valid
*
* Solution: matrix traversal, check by row, column, and submatrix
* follow-up: valid side length should be square of n
* follow-up: modify the program for any valid side length
* 
*/
public class validSudoku{
	
	public boolean isValidSudoku1(char[][] board) {
	    for(int i = 0; i<9; i++){
	        HashSet<Character> rows = new HashSet<Character>();
	        HashSet<Character> columns = new HashSet<Character>();
	        HashSet<Character> cube = new HashSet<Character>();
	        for (int j = 0; j < 9;j++){
	            if(board[i][j]!='.' && !rows.add(board[i][j]))
	                return false;
	            if(board[j][i]!='.' && !columns.add(board[j][i]))
	                return false;
	            int RowIndex = 3*(i/3);
	            int ColIndex = 3*(i%3);
	            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
	                return false;
	        }
	    }
	    return true;
	}
	
	
	
	public boolean isValidSudoku2(char[][] board) {
	    for (int i=0; i<9; i++) {
	        if (!isParticallyValid(board,i,0,i,8)) return false;
	    }
	    for (int i=0;i<3;i++){
	        for(int j=0;j<3;j++){
	            if (!isParticallyValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
	        }
	    }
	    return true;
	}
	private boolean isParticallyValid(char[][] board, int x1, int y1,int x2,int y2){
	    Set singleSet1 = new HashSet();
	    Set singleSet2 = new HashSet();
	    for (int i= x1; i<=x2; i++){
	        for (int j=y1;j<=y2; j++){
	            if (board[i][j]!='.') if(!singleSet1.add(board[i][j])) return false;
	            if (board[j][i]!='.') if(!singleSet2.add(board[j][i])) return false;
	        }
	    }
	    return true;
	}
}