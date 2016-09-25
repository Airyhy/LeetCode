package VFacebookTemp;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 */
public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) return null;

        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> contain = new HashMap();
        contain.put(root.label, root);

        Queue<UndirectedGraphNode> que = new LinkedList();
        que.add(node);

        while (que.isEmpty() == false) {
            UndirectedGraphNode temp = que.poll();
            UndirectedGraphNode copy = contain.get(temp.label);

            for (UndirectedGraphNode one : temp.neighbors) {
                UndirectedGraphNode copy1;
                if (contain.containsKey(one.label) == false) {
                    copy1 = new UndirectedGraphNode(one.label);
                    contain.put(one.label, copy1);
                    que.add(one);
                }

                copy1 = contain.get(one.label);

                copy.neighbors.add(copy1);
            }

        }
        return root;
    }

}
