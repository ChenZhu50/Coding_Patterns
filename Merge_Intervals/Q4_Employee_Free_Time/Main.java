import java.util.*;

public class Main {
    public static String display(List<Interval> l1) {
        if (l1.size() == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < l1.size(); i++) {
            sb.append("[").append(l1.get(i).start).append(", ")
                    .append(l1.get(i).end).append("]");
            if (i < l1.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // 示例1
        List<List<Interval>> example1 = Arrays.asList(
                Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                Arrays.asList(new Interval(1, 3)),
                Arrays.asList(new Interval(4, 10)));
        // 示例2
        List<List<Interval>> example2 = Arrays.asList(
                Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                Arrays.asList(new Interval(2, 4)),
                Arrays.asList(new Interval(2, 5), new Interval(9, 12)));

        // 组合成一个列表，方便循环输出
        List<List<List<Interval>>> inputs = Arrays.asList(example1, example2);

        int caseIndex = 1;
        for (List<List<Interval>> schedule : inputs) {
            System.out.println(caseIndex + ". Employee Schedules:");
            for (int i = 0; i < schedule.size(); i++) {
                System.out.println("\t" + display(schedule.get(i)));
            }

            // 调用 Solution 里的静态方法
            List<Interval> result = Solution.employeeFreeTime(schedule);
            System.out.println("   Employees' free time = " + display(result));
            System.out.println("---------------------------------------------------------");
            caseIndex++;
        }
    }
}
