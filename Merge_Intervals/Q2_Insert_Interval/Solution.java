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

    /*
     * current solution is okay, but O(N log N) is not the best solution
     */
    // public static int[][] insertInterval(int[][] existingIntervals, int[]
    // newInterval) {
    // // creat a linked list to store the merged intervals
    // LinkedList<int[]> merged = new LinkedList<>();

    // // still the base case, if null or empty, return empty array
    // if (existingIntervals == null || existingIntervals.length == 0) {
    // return new int[0][0];
    // }

    // // add the new interval to the existing intervals, and sort them by the first
    // // element
    // int[][] intervals = new int[existingIntervals.length + 1][2];
    // for (int i = 0; i < existingIntervals.length; i++) {
    // intervals[i] = existingIntervals[i];
    // }
    // intervals[existingIntervals.length] = newInterval;

    // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    // // add the first interval to the merged list
    // merged.add(intervals[0]);

    // // loop through the intervals
    // for (int i = 1; i < intervals.length; i++) {
    // int[] interval = intervals[i];
    // int[] lastAddedInterval = merged.getLast();

    // int currStart = interval[0];
    // int currEnd = interval[1];

    // int lastEnd = lastAddedInterval[1];

    // if (currStart <= lastEnd) {
    // lastAddedInterval[1] = Math.max(lastEnd, currEnd);
    // } else {
    // merged.add(interval);
    // }
    // }

    // return merged.toArray(new int[merged.size()][]);

    // }

    /*
     * This solution is O(N) time complexity, which is better than the previous one
     * 1. the intervals are sorted, we'll create an empty list to store the
     * intervals before the new interval
     * 2. add new interval to the list, and then merge the intervals if overlapping
     * 3. add the merged intervals to the list
     */
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        // todo: step 1: add existing intervals smaller then new interval
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // Initializing variable help iterating over the existing intervals
        int i = 0;
        int n = existingIntervals.length;

        // Initializing empty list to store the output
        LinkedList<int[]> merged = new LinkedList<>();

        // as long as the current intervals that start before the new interval, append

        while (i < n && existingIntervals[i][0] < newStart) {
            merged.add(existingIntervals[i]);
            i++;
        }

        // todo: step 2: check if overlap for our new interval

        // if the newStart < the end of last interval : append
        // int currEnd = merged.get(merged.size()-1)[1]; //can't work, we need to make
        // sure the merged size is > 0

        if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < newStart) {
            merged.add(newInterval);
        } else {
            // if we here, means there are overlap (currEnd > newStart)
            // compare which end is bigger ? curr or the new interval's
            merged.get(merged.size() - 1)[1] = Math.max(newEnd, merged.get(merged.size() - 1)[1]);
        }

        // todo: step 3: handle the remaining intervals
        while (i < n) {
            int[] currVals = existingIntervals[i];
            int start = currVals[0];
            int end = currVals[1];

            // int endOfList = merged.get(merged.size()-1)[1];

            if (merged.get(merged.size() - 1)[1] < start) {
                merged.add(currVals);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(end, merged.get(merged.size() - 1)[1]);
            }
            i++;
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
