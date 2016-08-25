package Heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class kthLargestIn_N_Arrays {

    public class Node{
        public int x;
        public int y;
        public int val;

        public Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int KthInArrays(int[][] arrays, int k) {

        //create comparator
        int arrayNum = arrays.length;
        PriorityQueue<Node> que = new PriorityQueue<Node>(k, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return n2.val - n1.val;
            }

        });

        //add the largest number
        for(int i=0; i< arrayNum; i++){
            Arrays.sort(arrays[i]);
            int arrayLen = arrays[i].length;
            if(arrayLen>0){
                que.add(new Node(i,arrayLen-1,arrays[i][arrayLen-1]));
            }
        }

        //remove one and add one
        while(k>1){
            Node node = que.poll();

            if(node.y>0) {
                que.add(new Node(node.x,node.y-1,arrays[node.x][node.y-1]));
            }
            k--;
        }
        return que.poll().val;
    }
    1
}
