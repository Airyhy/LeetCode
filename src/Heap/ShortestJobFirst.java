package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 第二道题我遇到的是SHORTEST JOB FIRST。
 * 给你的INPUT是两个ARRAY，一个是每个JOB的START TIME，一个是每个JOB的EXECUTION TIME。
 叫你求AVERAGE WAITING TIME。 学完OS课忘了，或者没学过的，都不用急， 它的描述里讲的很清楚怎么求，认识读几遍就行了。

 SJF is a Shortest Job First Scheduling Algorithm that assigns to each process the length of its next CPU execution time.
 CPU is then given to the process with the minimal CPU burst from the waiting queue.

 requestTime: [0, 2, 4, 5] duration: [7, 4, 1, 4] average waiting time 4

 example2:
 requestTime: [0, 1, 3, 9] duration: [2, 1, 7, 5] average waiting time 0.5
 */

public class ShortestJobFirst {

    //Assume the CPU has no waiting time, always running
    public static float SJFaverage(int[] request, int[] duration){
        if (request == null || duration == null || request.length == 0 || duration.length == 0){
            return 0;
        }

        int curEnd = 0;
        int n = request.length;
        boolean[] processed = new boolean[request.length];
        int minDuration = Integer.MAX_VALUE;
        int total = 0;
        // Arrays.fill(processed, false);
        int index = 0;

        while (n > 0){
            for (int i = 0; i < request.length; i++){
                if (request[i] <= curEnd && processed[i] == false && duration[i] < minDuration){
                    minDuration = duration[i];
                    index = i;
                }
            }

            processed[index] = true;
            total += curEnd - request[index];
            curEnd += duration[index];
            n--;
            minDuration = Integer.MAX_VALUE;
        }

        return (float)total / request.length;
    }





    public class Process{
        int executeTime;
        int arriveTime;

        public Process(int arriveTime, int executeTime){
            this.arriveTime = arriveTime;
            this.executeTime = executeTime;
        }
    }

    public  float shortestJobFirst1(int[] arriveTimes, int[] executeTimes) {
        if (arriveTimes == null || executeTimes == null || arriveTimes.length != executeTimes.length) {
            return 0;
        }
        int waitTime = 0, currentTime = 0, index = 0, length = arriveTimes.length;
        PriorityQueue<Process> heap = new PriorityQueue<Process>(10, new Comparator<Process>() {
            public int compare(Process a, Process b) {
                if (a.executeTime == b.executeTime) {
                    return a.arriveTime - b.arriveTime;
                } else {
                    return a.executeTime - b.executeTime;
                }
            }
        });

        while (!heap.isEmpty() || index < length) {
            if (!heap.isEmpty()) {
                Process current = heap.poll();
                waitTime += currentTime - current.arriveTime;
                currentTime += current.executeTime;

                while (index < length && currentTime >= arriveTimes[index]) {
                    heap.offer(new Process(arriveTimes[index], executeTimes[index]));
                    index++;
                }
            } else {
                heap.offer(new Process(arriveTimes[index], executeTimes[index]));
                currentTime = arriveTimes[index];
                index++;
            }
        }
        return (float) waitTime / length;
    }
}
