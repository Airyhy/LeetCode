package VFacebookTemp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**

 Serialization is the process of converting a data structure or object into a sequence of bits
 so that it can be stored in a file or memory buffer, or transmitted across a network connection link to
 be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree.
 There is no restriction on how your serialization/deserialization algorithm should work.
 You just need to ensure that a binary tree can be serialized to a string and
 this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

  1
 /  \
 2   3
 /   \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 You do not necessarily need to follow this format,
 so please be creative and come up with different approaches yourself.

 Note: Do not use class member/global/static variables to store states.
 Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * DFS
     */
    private static final String spliter = ",";
    private static final String NullNode = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NullNode).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NullNode)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }


    /**
     * BFS
     */
    public String serialize1(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize1(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        int i = 1;

        while (q.isEmpty()==false) {
            TreeNode parent = q.poll();
            if(parent==null){continue;}
            TreeNode left = null, right =null;
            if (!values[i].equals("n")) {
                left = new TreeNode(Integer.parseInt(values[i]));
            }
            parent.left = left;
            q.add(left);
            i++;
            if (!values[i].equals("n")) {
                right = new TreeNode(Integer.parseInt(values[i]));
            }
            parent.right = right;
            q.add(right);
            i++;
        }
        return root;
    }
}
