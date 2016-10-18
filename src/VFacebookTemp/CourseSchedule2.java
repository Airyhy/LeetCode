package VFacebookTemp;

import java.util.*;

/**
 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs,
 return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them.
 If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0.
 So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 Read more about how a graph is represented.

 */

public class CourseSchedule2 {

    /**
     * BFS - just add an output arraylist
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Arrays.fill(result,-1);

        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[idx++] = course;
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }

        if( result[numCourses-1] == -1){
            return new int[0];
        }
        return result;
    }


    /**
     * DFS - just add a stack to push and pop out the result
     * Use visited to store all the calculated result
     * Use inloop to count the working node, and find conflict if working node is needed as prerequists
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        boolean[] inloop = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        int[] fiorder = new int[numCourses];

        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int [] pair :prerequisites){
            graph[pair[1]].add(pair[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(visit(i,stack,graph,visited,inloop)==false){
                return  new int[0];

            }
        }

        int idx = 0;
        while (!stack.isEmpty()) {
            fiorder[idx++] = stack.pop();
        }
        return fiorder;
    }

    public boolean visit(int one,Stack<Integer> stack,List<Integer>[] graph,boolean[] visited,boolean[] inloop  ){
        if(visited[one]) return true;
        if(inloop[one]==true) return false;
        else inloop[one] = true;

        for(Integer u : graph[one]){
            if(visit(u,stack,graph,visited,inloop)==false){
                return false;
            }
        }

        inloop[one] = false;
        visited[one] = true;
        stack.push(one);
        return true;
    }
}
