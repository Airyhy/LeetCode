package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * robin wait time。
 大概是这样，给一个int[] arrival time, int[] Execution time, int q.
 例子： 【0，1，4】 【5，2，3】 q=3. 输出的是average wait time 2.3333333

 / e.g.
 // arrival_time = [0, 1, 4], execution_time = [5, 2, 3], q = 3
 // average wait time = (7 - 5) + (5 - 3) + (10 - 7) / 3 = 2.3333333 // q is quantum

 */
public class RoundRobinWaitTime {

        // SOL 1
        public static float waitingTimeRobin1(int[] arrival, int[] run, int q) {
            // corner case
             if (arrival == null || run == null || arrival.length != run.length) {
                return 0;
             }

            // use Queue to store Process type elements
            Queue<Process> queue = new LinkedList<Process>();
            int curTime = 0;
            int waitTime = 0;

            // use a int type variable to track the next Process index
            int nextProIdx = 0;

            while (!queue.isEmpty() || nextProIdx < arrival.length) {
                if (!queue.isEmpty()) {
                    Process cur = queue.poll();
                    // continue suming up the waitTime
                    waitTime += curTime - cur.arriveTime;
                    // based on Round Robin's principle, every round time is limited within the certain quantum q
                    // if exceed time q, the not finished process should be forced to be interrupted,
                    // and switch to the next process waiting in the Queue than current time the Queue

                    curTime += Math.min(cur.excuteTime, q);
                    // if arrival time of the next process is smaller
                    // means the next process should be pushed into the Queue
                    for (int i = nextProIdx; i < arrival.length; i++) {
                        if (arrival[i] <= curTime) {
                            queue.offer(new Process(arrival[i], run[i]));
                            nextProIdx = i + 1;
                        } else {
                            break;
                        }
                    }

                    // push the interrupted process into the tail of
                    if (cur.excuteTime > q) {
                        queue.offer(new Process(curTime, cur.excuteTime - q));
                    }
                } else {
                    // push element in arrival time array and
                    // corresponding element in run time array into Queue
                    queue.offer(new Process(arrival[nextProIdx],run[nextProIdx]));

                    // at the same update the current time point
                    curTime = arrival[nextProIdx];
                    nextProIdx++;
                }
            }
            return (float)waitTime / arrival.length;
        }
        // declare a Process type to store arrival time array and run time array
        public static class Process {
            int arriveTime;
            int excuteTime;
            Process(int arr, int exc) {
                arriveTime = arr;
                excuteTime = exc;
            }
        }
        public static void main(String[] args) {
            int[] arrival1 = {0, 1, 4};
            int[] run1 = {5, 2, 3};
            int q1 = 3;
            int[] arrival2 = {0, 1, 3, 9};
            int[] run2 = {2, 1, 7, 5};
            int q2 = 2;
            System.out.print(waitingTimeRobin1(arrival2, run2, q2));
        }
    }
