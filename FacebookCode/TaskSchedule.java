import java.util.HashMap;
import java.util.Map;

public class TaskSchedule {



    /**
     *之后上题（运气挺好的这次还是只有一道）。给了一串task，不同的task可能属于不同type。
     * 这些task要放到CPU里运行，运行同一种type是要考虑一个冷却时间。。。弄了半天，过了好几个例子才搞明白，就类似于一个OS。
     * 给你一个单线程的scheduler，和eg. 4种thread：1，2，3，4, 冷却时间: 3，
     * 在multithreading的时候同类型的thread要等上一个thread跑完冷却时间之后才能运行，
     * 求最后scheduler用了多少time slot。
     * hread: 1, 2, 1, 1, 3, 4;
     * 应该改为1, 2, _, 1, _, _, 1, 3, 4，最后返回9
     * 想了一下就用个map存了不同type最近的time slot，每碰到相同的type就check一下冷却时间过了没，没过就等待。
     * 写到等待的地方，在考虑时间要不要加一的时候，脑子有点绕晕了。。。最后觉得不用加一，就告诉小哥我写完了，跑了一个test case发现撒比。。
     * 加上一，过了。
     *
     * Use the map to store the next position
     * 在这个基础上，已知cooldown会很小，可以视作constant，task的type会很多，让我减少空间复杂度。
     * 我用了queue，queue的size和cooldown一样。
     * */
    //O(n) O(n)
    public int taskScheduleCurTime(int[] nums, int interval) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = 0;

        //the value is the next position where this task can be implemented
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]) || map.get(nums[i]) <= ret) {
                ret++;
            } else {
                ret = map.get(nums[i]) + 1;
            }
            map.put(nums[i], ret + interval);
        }
        return ret;
    }
    /**
     * Follow-up add '_' to the string
      Tasks: 1, 1, 2, 1
     # Recovery interva (cooldown): 2
     # Output: 7  (order is 1 _ _ 1 2 _ 1)

     # Example 2
     . From 1point 3acres bbs
     # Tasks: 1, 2, 3, 1, 2, 3
     # Recovery interval (cooldown): 3
     # Output: 7  (order is 1 2 3 _ 1 2 3)

     # Example 3

     # Tasks: 1, 2, 3 ,4, 5, 6, 2, 4, 6, 1, 2, 4
     # Recovery interval (cooldown): 6
     # Output: 18  (1 2 3 4 5 6 _ _ 2 _ 4 _ 6 1 _ 2 _ 4)
     */
    public List<Integer> taskSchedulePrint(String[] tasks, int cooldown) {
        List<Integer> ret = new  LinkedList<Integer>();
        if (tasks == null || tasks.length == 0) {
            return;
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int cur = 0;
        for(int i = 0; i < tasks.length; i++) {
            while (map.containsKey(tasks[i]) && map.get(tasks[i]) + cooldown >= cur) {
                ret.add("_");
                cur++;
            }
            ret.add(tasks[i]);
            map.put(tasks[i], cur);
            cur++;
        }
        return ret;
    }


    /**
     * Follow Up
     * Follow up是如何schedule这些工作，这样最后的工作总时间最少。我说了一种greedy的算法，就是相同task相隔约长约好。
     * 但是不太对，小哥说其实是一旦数量最多的task cooldown时间到了，就schedule这个task。问了我大概怎么实现，就结束了。
     *
     */

    public String rearrangeString(String str, int k) {

        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });

        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }

        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }




    /**
     * Follow up:
     * Find the task that appears for the most time
     * Use a map to count the number of the times the task appears  then get the maximum count
     * the result is decided by the maximum count and the number of tasks with maximum count
     *
     * two conditions:
     * 1.  5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4  the rest tasks cannot fill the empty slots
     *     5 4 3 2 _ 5 4 3 2 _ 5 4 _ _ _ 5 4
     *     the answer is (maxCount - 1) * (interval + 1) + CountOfMax
     * 1. 5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4  the rest tasks cannot fill the empty slots
     *    5 4 3 2 1 6 5 4 3 2 1 6 5 4 6 _ _ 5 4
     *    the answer is the length of the nums
     *    the task which does not have max count first fills the empty slots and then just insert any valid place
     * */

    //O(n) O(n)
    public int taskScheduleMostTime(int[] nums, int interval) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int countOfMax = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : nums) {
            map.put(task, map.containsKey(task) ? map.get(task) + 1 : 1);
            if (max == map.get(task)) {
                countOfMax++;
            } else if (max < map.get(task)) {
                max = Math.max(max, map.get(task));
                countOfMax = 1;
            }
        }


        return Math.max(nums.length, (max - 1) * (interval + 1) + countOfMax);
    }

    public static void main(String[] arg) {
        TaskSchedule a = new TaskSchedule();
        System.out.println(a.taskSchedule(new int[]{1}, 1));
        System.out.println(a.taskSchedule(new int[]{1, 1}, 2));
        System.out.println(a.taskSchedule(new int[]{1, 2, 1, 3, 2}, 2));
        System.out.println(a.taskSchedule(new int[]{1, 1, 2, 1}, 2));
        System.out.println(a.taskSchedule(new int[]{1, 2, 3, 1, 2, 3}, 3));

        System.out.println();
        System.out.println(a.taskScheduleUnorder(new int[]{1}, 1));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 1}, 2));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 2, 1, 3, 2}, 2));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 1, 2, 1}, 2));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 2, 3, 1, 2, 3}, 3));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 1, 2, 2, 3, 3}, 3));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 3, 2, 4, 5, 1}, 3));
    }
}
