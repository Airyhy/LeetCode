public class validBST{

	//recursive
	Integer pred = null;
    public boolean isValidBST(TreeNode root) {
        
        return helper(root,null,null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root==null)  return true;
        if( (min!=null && root.val<=min) || (max!=null && root.val>=max)){
            return false;
        }
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }

    
    
     //use inorder traversal
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> result = new ArrayList<Integer>();
        inOrderList(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    public void inOrderList(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderList(root.left, res);
        res.add(root.val);
        inOrderList(root.right, res);
    }
}