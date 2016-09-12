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


}