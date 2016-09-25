package Greedy;

import java.util.PriorityQueue;

/**
 * A small frog wants to get to the other side of a river.
 * The frog is currently located at position 0, and wants to get to position X.
 * Leaves fall from a tree onto the surface of the river.

 You are given a non-empty zero-indexed array A consisting of N integers representing the falling leaves.
 A[K] represents the position where one leaf falls at time K, measured in minutes.

 The goal is to find the earliest time when the frog can jump to the other side of the river.
 The frog can cross only when leaves appear at every position across the river from 1 to X.

 For example, you are given integer X = 5 and array A such that:
 A[0] = 1
 A[1] = 3
 A[2] = 1
 A[3] = 4
 A[4] = 2
 A[5] = 3
 A[6] = 5
 A[7] = 4

 And a frog can jump distance of 3 :), more difficult yep

 */
public class frogJump {

    public int frog(int X, int[] A, int jump) {
        int steps = X;
        boolean[] bitmap = new boolean[steps+1];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cur = 0;
        int far = jump;

        for(int i = 0; i < A.length; i++){

            if( far >= A[i] ){
                cur = Math.max(cur,A[i]);
                far = cur + jump;
                while(heap!=null && heap.peek()<=far) {
                    cur = Math.max(cur,heap.poll());
                    far = cur + jump;
                }
            }else{
                heap.add(A[i]);
            }

            if (far >= X){
                return i;
            }
        }
        return -1;
    }

}
