package binaryTreeSearch;

import java.util.*;

public class course_schedule {
    /**
     * LeetCode 207: Course Schedule
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
     * Some courses may have prerequisites, given as pairs [a, b] meaning to take course a you must first take course b.
     * Return true if it is possible to finish all courses, otherwise return false.
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();

        //初始化adjacency，因为是个二维数组
        for(int i= 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }

        //建立indegree和adjancency
        for(int [] cp : prerequisites){
            indegree[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        //初始遍历条件，找到indegree中为0的加入queue中
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses --;
            for(int cur : adjacency.get(pre)){
                indegree[cur] --;
                if(indegree[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        // Test cases: {numCourses, prerequisites, expected output}
        Object[][] testCases = {
            {2, new int[][]{{1,0}}, true},
            {2, new int[][]{{1,0},{0,1}}, false},
            {4, new int[][]{{1,0},{2,1},{3,2}}, true},
            {3, new int[][]{{1,0},{2,1},{0,2}}, false},
            {1, new int[][]{}, true},
        };

        for (int i = 0; i < testCases.length; i++) {
            int numCourses = (int) testCases[i][0];
            int[][] prerequisites = (int[][]) testCases[i][1];
            boolean expected = (boolean) testCases[i][2];
            boolean result = canFinish(numCourses, prerequisites);
            System.out.println("Test case " + (i+1) + ": numCourses = " + numCourses + ", prerequisites = " + Arrays.deepToString(prerequisites));
            System.out.println("Output: " + result + ", Expected: " + expected + ", Pass: " + (result == expected));
            System.out.println();
        }
    }
}
