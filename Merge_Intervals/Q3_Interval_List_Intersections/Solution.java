package Merge_Intervals.Q3_Interval_List_Intersections;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        //todo: 1. set two pinters to iterate over the two lists
        int i = 0, j = 0;
        
        //todo: 2. while iterating, find the latest start and the earliest end for each pair
        
        // make the return list
        LinkedList<int[]> result = new LinkedList<>();

        // while loop for iterating over the two lists, finding the latest starting time and the earliest ending time
        while(i < intervalLista.length && j < intervalListb.length){
            //starting time for both interval(use to find the min)
            int intervalAStart = intervalLista[i][0];
            int intervalBStart = intervalListb[j][0];

            //end time for both interval
            int intervalAEnd = intervalLista[i][1];
            int intervalBEnd = intervalListb[j][1];

            //checking if there are overlapping
            //by checking the min end time is larger or equal to start
            
            int startIntersection = Math.max(intervalAStart, intervalBStart);
            int endIntersection = Math.min(intervalAEnd, intervalBEnd);

            if(startIntersection <= endIntersection){
                result.add(new int[]{startIntersection, endIntersection});
            }

            //todo: 3. increment the pointer by checking who having the smaller end time
            if(intervalAEnd < intervalBEnd){
                i++;
            }else{
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
    // Driver code
    public static void main(String args[]) {
        int[][][] inputIntervalLista = {
                {{1, 2}},
                {{1, 4}, {5, 6}, {9, 15}},
                {{3, 6}, {8, 16}, {17, 25}},
                {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}},
                {{1, 3}, {5, 6}, {7, 8}, {12, 15}}
        };

        int[][][] inputIntervalListb = {
                {{1, 2}},
                {{2, 4}, {5, 7}, {9, 15}},
                {{2, 3}, {10, 15}, {18, 23}},
                {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}},
                {{2, 4}, {7, 10}}
        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(intervalsIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
