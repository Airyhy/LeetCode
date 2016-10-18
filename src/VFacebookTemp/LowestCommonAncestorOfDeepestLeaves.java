package VFacebookTemp;

/**
 *     1
     2   3.
        5  6    return 3.

         1
        2   3
    4      5 6   retrun 1.
 先用 recursive  ， 很快写出来了， 要求用 iterative 。 时间不够了。。

 有什么比较好的办法 ？
 */
public class LowestCommonAncestorOfDeepestLeaves {


    /**
     * 最近这个题很高频啊，其实dfs遍历，返回的时候返回lca和depth，每个node如果有大于一个子节点的depth相同就返回这个node，
     * 如果有一个子节点depth更深就返回个子节点lca，这个o(n)就可以了／ post order traversal用hashmap存每个child node的深度和candidate
     */

    private class ReturnVal {
        public int depth;   //The depth of the deepest leaves on the current subtree. more info on 1point3acres.com
        public TreeNode lca;//The lca of the deepest leaves on the current subtree

        public ReturnVal(int d, TreeNode n) {
            depth = d;
            lca = n;
        }
    }

    public TreeNode LowestCommonAncestorOfDeepestLeaves(TreeNode root) {
        ReturnVal res = find(root, 0);
        return res.lca;
    }

    private ReturnVal find(TreeNode root, int depth) {
        if(root == null) {
            return new ReturnVal(-1, null);
        } else {
            ReturnVal lRes = find(root.left, depth+1);
            ReturnVal rRes = find(root.right, depth+1);

            if(lRes.depth == rRes.depth) {
                return new ReturnVal(lRes.depth==-1?depth:lRes.depth, root);
            } else {
                return new ReturnVal(Math.max(rRes.depth, lRes.depth), rRes.depth>lRes.depth?rRes.lca:lRes.lca);
            }
        }
    }


    /**
     *
     BFS也可以 level order traversal 每个node 都带一个path info  比如向左是0  向右是1  最后一层的所有node的共同前缀就是lca
     第一个例子 最后一层5 、6 就是010 011  共同前缀是01  也就是 3那个node 第二个例子最后一层是4 5 6
     就是000 010 011  共同前缀是0  就是root 1 node。

     每个 node向上返回一步， 把它们的parent用一个set来记录， 迭代， 当set的 size为1的时候就是他们的lowest common ancestor。
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
