package Heap;

/**
 * Given an integer array, heapify it into a min-heap array.

 For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i]
 and A[i * 2 + 2] is the right child of A[i].
 */
public class Heapify {

    // Version 1: this cost O(n)

    private void siftdown(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
                smallest = k * 2 + 1;
            }
            if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
                smallest = k * 2 + 2;
            }
            if (smallest == k) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;

            k = smallest;
        }
    }

    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }



    // Version 2: This cost O(nlogn)

    private void siftup(int[] A, int k) {
        while (k != 0) {
            int father = (k - 1) / 2;
            if (A[k] > A[father]) {
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;

            k = father;
        }
    }

    public void heapify2(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }

}
