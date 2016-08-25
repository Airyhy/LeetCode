//给一个矩阵，M＊N，从左上角的点开始走，一直到右下角的点，只能先下和向右，输出所有路径
public class MatrxPath{

	//print a list contains all the path in a matrix
public List<String> allpath (int m,int n,){
	List<String> result = new ArrayList<String>();
	DFS(m,n,0,0,new String(),result);
	return result;
} 

public void getpath(int m,int n,int i,int j, String path,List<String> allpath){
	path = path + (“,”+i+”,”+”j”);
	if(i==m - 1 && j==n - 1){
		allpath.add(path)
	}
	else if(i>=m || j>=n){
		return;
	}else{
		getpath(m,n,i+1,j,new ArrayList(path),allpath);
		getpath(m,n,i,j+1,new ArrayList(path),allpath);
	}
}

//check if there exists a path
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
		maze[x][y] = 0;
		return dfs(maze, x + 1, y) || dfs(maze, x, y + 1) || dfs(maze, x - 1, y) || dfs(maze, x, y - 1);
	}
}
}
}