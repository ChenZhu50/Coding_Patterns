import java.util.*;

public class Solution {

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        /*
         * 初始化最小堆，并将每个员工的第一个会议加入堆中。
         * 将第一个会议的起始时间设为基准（previous interval）。
         * 不断弹出堆中最早的会议，并与当前基准区间进行比较。
         * 如果当前会议的开始时间大于基准区间的结束时间，则存在空闲时间，加入结果列表。
         * 更新基准区间，将其设置为当前会议结束时间和基准结束时间的较大值。
         * 如果该员工有下一个会议，将其加入堆中继续比较。
         * 堆为空时，返回结果列表。
         */

        // 创建一个最小堆，这个堆保证了堆顶部元素一定是 x[0] 这个位置最小的元素
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 将所有员工的第一个会议时间放入堆内
        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> employeeSchedule = schedule.get(i); // 拿到第 i 个员工的 schedule
            Interval interval = employeeSchedule.get(0); // 当前员工的第一个会议

            // 将之前得到的 interval 插入，并用 i 来表示这是第几个员工。 0 表示这是当前员工的第 0 场会议
            minHeap.offer(new int[] { interval.start, i, 0 }); // offer 等同于 add，但堆满时不会抛异常，会自动扩容
        }

        List<Interval> ans = new ArrayList<>();

        /*
         * 用 previous 来装载最早开始时间
         *
         * minHeap.peek()[1] 表示堆顶元素的员工编号
         * minHeap.peek()[2] 表示堆顶元素的第几场会议
         * schedule.get(minHeap.peek()[1]).get(minHeap.peek()[2]).start
         * == schedule.get(栈顶员工).get(栈顶员工的会议).start
         *
         * 当前情况则会是第一名员工的第一场会议的开始时间
         */
        int previous = schedule.get(minHeap.peek()[1]).get(minHeap.peek()[2]).start; // peek 不会弹出元素，而是仅仅看一下

        // 只要堆内还有元素
        while (!minHeap.isEmpty()) {
            // 弹出最早的会议
            int[] tuple = minHeap.poll(); // [startTime, employeeIndex, intervalIndex]
            int i = tuple[1]; // 员工编号
            int j = tuple[2]; // 该员工第 j 场会议

            Interval interval = schedule.get(i).get(j);

            // 如果当前会议的开始时间比 previous 大，则表示两场会议之间出现空闲
            // 例如，现在的 start = 6， previous = 4，这说明从 4~6 是空闲
            if (interval.start > previous) {
                ans.add(new Interval(previous, interval.start));
            }

            // 更新 previous，看当前会议结束时间更大，还是之前的结束时间更大
            // 例如，我有个会议区间 [2,7]，另一个 [5,6]，则要取 max(7, 6)
            previous = Math.max(previous, interval.end);

            // 将当前员工的下一个会议推入堆中
            if (j + 1 < schedule.get(i).size()) {
                Interval nextInterval = schedule.get(i).get(j + 1);
                minHeap.offer(new int[] { nextInterval.start, i, j + 1 });
            }
        }
        return ans;
    }
}
