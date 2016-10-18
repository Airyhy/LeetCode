package VFacebookTemp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 Read more about how a graph is represented.

 click to show more hints.

 Hints:
 This problem is equivalent to finding if a cycle exists in a directed graph.
 If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 Topological sort could also be done via BFS.
 */
public class CourseSchedule {

    /**
     * BFS
     * Convert it to adjancent matrix, and then count the unique prerequists
     * start from course need no prerequist to find next course that only need this prerequist
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }

    /**
     * DFS
     * make sure all the prerequists are good in each course
     */
    boolean[] visited;

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] inloop = new boolean[numCourses];
        visited = new boolean[numCourses];

        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,inloop,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] inloop, int course){
        if(visited[course]){
            return true;
        }

        if(inloop[course])
            return false;
        else
            inloop[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,inloop,(int)graph[course].get(i)))
                return false;
        }

        inloop[course] = false;
        visited[course] = true;
        return true;
    }

}
