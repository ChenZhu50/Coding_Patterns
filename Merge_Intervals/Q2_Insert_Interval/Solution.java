package Merge_Intervals.Q2_Insert_Interval;

import java.util.LinkedList;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] newIntervals = {
                { 5, 7 },
                { 8, 9 },
                { 10, 12 },
                { 1, 3 },
                { 1, 10 }
        };

        int[][][] existingIntervals = {
                { { 1, 2 }, { 3, 5 }, { 6, 8 } },
                { { 1, 3 }, { 5, 7 }, { 10, 12 } },
                { { 8, 10 }, { 12, 15 } },
                { { 5, 7 }, { 8, 9 } },
                { { 3, 5 } }
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        // creat a linked list to store the merged intervals
        LinkedList<int[]> merged = new LinkedList<>();

        // still the base case, if null or empty, return empty array
        if (existingIntervals == null || existingIntervals.length == 0) {
            return new int[0][0];
        }

        // add the new interval to the existing intervals, and sort them by the first
        // element
        int[][] intervals = new int[existingIntervals.length + 1][2];
        for (int i = 0; i < existingIntervals.length; i++) {
            intervals[i] = existingIntervals[i];
        }
        intervals[existingIntervals.length] = newInterval;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // add the first interval to the merged list
        merged.add(intervals[0]);

        // loop through the intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] lastAddedInterval = merged.getLast();

            int currStart = interval[0];
            int currEnd = interval[1];

            int lastEnd = lastAddedInterval[1];

            if (currStart <= lastEnd) {
                lastAddedInterval[1] = Math.max(lastEnd, currEnd);
            } else {
                merged.add(interval);
            }
        }

        return merged.toArray(new int[merged.size()][]);

    }
}
