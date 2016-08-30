package Matrix;

public class PrintDianalg{


	/**
	 *
	 * print from left up to right bottom, right up direction
     */
	public void printdial(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int row = matrix.length;
		int col = matrix[0].length;

		//print up left big trangle
		for (int i = 0; i < row; i++) {
			int j = 0;
			while (i >= 0 && i < row && j >= 0 && j < col) {
				System.out.print(matrix[i][j]);
				i--;
				j++;
			}
		}

		//print bottom right small trangle
		for (int j = 1; j < col; j++) {
			int i = row - 1;
			while (i >= 0 && i < row && j >= 0 && j < col) {
				System.out.print(matrix[i][j]);
				i--;
				j++;
			}
		}
	}

	//	if its a square, one side length = dim
	public void printdia(int[][] array){
		int dim = array.length;

	    for( int k = 0 ; k < dim * 2 ; k++ ) {
	        for( int j = 0 ; j <= k ; j++ ) {
	            int i = k - j;
	            if( i < dim && j < dim ) {
	                System.out.print( array[i][j] + " " );
	            }
	        }
	        System.out.println();
	    }
	}
	
}
