package SlidingWindow.Q5_Diet_Plan_Performance;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static int dietPlanPerformance(List<Integer> calories, int k, int lower, int upper) {
        /*
         * 1.初始化，像上一题一样得到当前windows的sum。然后通过+-来保持size大小和更新sum
         * 2. if条件判断，如果大于最大 那么result+1 ，反则-1
         * 3. 返回这个result
         */

        // 初始化 current_sum
        int current_sum = 0;
        int result = 0;

        for (int i = 0; i < k; i++) {
            current_sum += calories.get(i);
        }
        if (current_sum < lower)
            result += -1;
        if (current_sum > upper)
            result += 1;

        for (int i = 0; i + k < calories.size(); i++) {
            current_sum -= calories.get(i);
            current_sum += calories.get(i + k);
            if (current_sum < lower)
                result += -1;
            if (current_sum > upper)
                result += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(3, 5, 8, 2, 6), // Test Case 1: Mixed performance
                Arrays.asList(1, 1, 1, 1, 1), // Test Case 2: All sums below lower limit
                Arrays.asList(10, 12, 15, 20, 25), // Test Case 3: All sums above upper limit
                Arrays.asList(5, 10, 15, 20, 25, 30), // Test Case 4: Mix of poor, normal, and good performances
                Arrays.asList(3, 8, 7, 4, 5, 6) // Test Case 5: Sliding window with variable performance
        );

        int[] ks = { 2, 2, 3, 3, 2 };
        int[] lowers = { 7, 5, 10, 20, 7 };
        int[] uppers = { 10, 10, 30, 40, 10 };

        // Run each test case
        for (int i = 0; i < testCases.size(); i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.print("\tcalories = [");
            String s = "";
            for (int j = 0; j < testCases.get(i).size(); j++) {
                s += testCases.get(i).get(j);
                if (j != testCases.get(i).size() - 1) {
                    s += ", ";
                }
            }
            System.out.println(s + "]");
            System.out.println("\tk = " + ks[i]);
            System.out.println("\tlower = " + lowers[i]);
            System.out.println("\tupper = " + uppers[i]);
            int result = dietPlanPerformance(testCases.get(i), ks[i], lowers[i], uppers[i]);
            System.out.println("\n\tpoints = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
