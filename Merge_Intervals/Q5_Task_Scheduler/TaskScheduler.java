package Merge_Intervals.Q5_Task_Scheduler;

import java.util.Arrays;

public class TaskScheduler {
    /*
     * 1. 计算出任务的出现频率
     * 2. 按照出现频率从高到低排序
     * 3. 先分配出现最高的任务，其余格子内填入Idle
     * 4. 用其他任务填充Idle
     */
    public static int leastTime(char[] tasks, int n) {
        //todo：计算任务出现频率
        int[] freq = new int[26]; //因为只有26个字母
        for (char task : tasks) { //遍历任务
            freq[task - 'A']++; // task为当前任务，task - 'A'为当前任务的索引
        }

        //todo：按照出现频率从高到低排序
        Arrays.sort(freq); //如果我们只有ABC，则其他字母的频率为0，所以排序后，freq[25]为出现最高的任务
        
        //todo：先分配出现最高的任务，其余格子内填入Idle
        int maxFreq = freq[25] - 1; //最高频率的任务 -1是因为最后一个任务不需要Idle ，假设是AABBC，那么A的频率为2，B的频率为2，C的频率为1，那么最后一个任务不需要Idle
        int idleSlots = maxFreq * n;// 用来填充Idle的格子数
        
        //todo：用其他任务填充Idle
        for (int i = 24; i >= 0; i--) { //从频率第二高的任务开始
            idleSlots -= Math.min(freq[i], maxFreq); //如果当前任务的频率小于最高频率，那么用当前任务填充Idle
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length; //如果idleSlots大于0，那么返回idleSlots + tasks.length，否则返回tasks.length
    }
}
