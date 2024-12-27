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

        //? 为什么这里初始化是开始时间，而不是结束时间？
        // 因为在下面的代码 if (interval.start > previous)中，我们比较的是开始时间，如果是结束时间则会将错误的时间推入ans中。
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
            // !: 在第一次更新的时候，会比较的就是我们初始员工的，然后我们的previous就会正常化的存储到当前一个员工的第一个场会议结束时间
            //如果别人的starting time > 我结束的时间，就证明我存在一个空闲

            //? 如果员工1和员工2之间存在空隙，但是3的存在让这个空隙消失了。会不会这个空隙已经被填入我们的ans中？
            //不会，因为heap的排序方式让我们必须开始时间小的在前面，而不管插入顺序。所以这种情况不可能发生。

            //? 为什么之前比较的是开始时间，现在找max end了？
            // 因为我们只需要知道开始时间最早，结束时间最晚的人的空闲区。
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
