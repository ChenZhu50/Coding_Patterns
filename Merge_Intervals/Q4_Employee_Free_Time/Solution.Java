import java.util.*;

class Solution {
    class Interval{
        int start;
        int end;
        boolean closed;
    
        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
            this.closed = true; // by default, the interval is closed
        }
    
        // set the flag for closed/open
        public void setClosed(boolean closed)
        {
            this.closed = closed;
        }

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

        
        //创建一个最小堆，这个堆保证了堆顶部元素一定是x[0] 这个位置最小的元素
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);


        //将所有员工的第一个会议时间放入堆内
        for(int i = 0; i < schedule.size(); i++){
            List<Interval> employeeSchedule = schedule.get(i) //拿到第n个员工的schedule
            Interval interval = employeeSchedule.get(0) //当前员工的第一个会议

            //将之前得到的interval插入，并用i来表示这是第几个员工。 0 表示的是这是当前员工的第几个会议
            minHeap.offer(new int[]{interval.start, i, 0}); //offer 方式等同于add，但是如果堆满了会自动延展，不会抛出异常。
        }

        List<Interval> ans = new ArrayList<Interval>();

        //用previou来装载第一个interval的开始时间
        /*
         * minHeap.peek()[1] 表示栈顶元素的员工编号
         * minHeap.peek()[2] 表示栈顶元素的第几个场会议
         * schedule.get(minHeap.peek()[1]).get(minHeap.peek()[2]).start
         *              ==
         *  schedule.get(栈顶员工).get(栈顶员工的会议) 的开始时间
         * 
         * 当前情况则会是第一名员工的第一场会议的开始时间
         */
        int previous = schedule.get(minHeap.peek()[1]).get(minHeap.peek()[2]).start; // peek不会弹出栈顶元素，而是看看而已

        //只要栈内还有元素
        while(!minHeap.isEmpty()){
            //弹出第一个元素，并取得其
            int[] tuple = heap.poll(); //[start_time, employee_index, interval_index]
            int i = tuple[1]; //员工编号
            int j = tuble[2]; //该员工第j场会议

            Interval interval = schedule.get(i).get(j);

            //如果我当前会议的开始时间比previous大的话，则表示两场会议有空闲时间
            //比如 现在的start = 6， previous  = 4. 这就说明从4-6点是空闲的
            //那么我们就将previous的时间作为start 会议开始时间为 end 写入ans中
            if(interval.start > previous){
                ans.add(new Interval(previous, interval.start));
            }

            //更新previous，看看当前会议结束时间更大，还是之前的会议结束时间更大
            //比如说，我有个会议从2-7点，另一场5-6点
            previous = Math.max(previous, interval.end);

            // 将当前员工的下一个会议推入堆中
            if (j + 1 < schedule.get(i).size()) {
                Interval nextInterval = schedule.get(i).get(j + 1);
                minHeap.offer(new int[]{nextInterval.start, i, j + 1});
            }
        }
        return ans;
    }
}