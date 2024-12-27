package Merge_Intervals.Q5_Task_Scheduler;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        char[][] allTasks = {
          {'A', 'A', 'B', 'B'},
          {'A', 'A', 'A', 'B', 'B', 'C', 'C'},
          {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'},
          {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'},
          {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}};

        int[] allNs = {2, 1, 0, 3, 3};

        for (int i = 0; i < allTasks.length; i++) {
          System.out.print((i + 1) + ".\tTasks: ");
          char[] tasks = allTasks[i];
          for(int j = 0; j < tasks.length; j++) {
            System.out.print(tasks[j]);
            if (j != tasks.length - 1) {
                System.out.print(", ");
            }
          }
          System.out.println("\n\tn: " + allNs[i]);

          int minTime = TaskScheduler.leastTime(allTasks[i], allNs[i]);
          System.out.println("\tMinimum time required to execute the tasks: " + minTime);
          System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
