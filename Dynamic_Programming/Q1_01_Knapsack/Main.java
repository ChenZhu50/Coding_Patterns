package Q1_01_Knapsack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] weights = {
            { 1, 2, 3, 5 },
            { 4 },
            { 2 },
            { 3, 6, 10, 7, 2 },
            { 3, 6, 10, 7, 2, 12, 15, 10, 13, 20 }
        };

        int[][] values = {
            { 1, 5, 4, 8 },
            { 2 },
            { 3 },
            { 12, 10, 15, 17, 13 },
            { 12, 10, 15, 17, 13, 12, 30, 15, 18, 20 }
        };

        int[] capacity = { 6, 3, 3, 10, 20 };
        
        // Let's uncomment this to see the benefit of using dynamic programming with tabulation
        
        // int newWeights[][] = Arrays.copyOf(weights, weights.length + 1);
        // newWeights[weights.length] = new int[]{63,  55,  47,  83,  61,  82,   6,  34,   9,  38,   6,  69,  17,
        //     50,   7, 100, 101,   4,  41,  28, 119,  78,  98,  38,  75,  35,
        //      8,  10,  16,  93,  34,  23,  51,  79, 118,  86,  85, 109,  88,
        //     72,  99,  36,  21,  80,  42,  44,  62,   7,  54,   7,   6,   0,
        //     65,  25,  44,  86,  76,  18,  11,  10, 104,  17,  36,  91,  78,
        //     88,  79, 103,   1,   4,  34,  94,  73,  21,   8,   9,  79,  25,
        //    106,  76,  39,  78,   1,  92, 104,  84,  40, 100, 116,  84,  23,
        //     79, 109,  79,  71,  72, 116,  90,  79,  26};
        // weights = newWeights;

        // int newValues[][] = Arrays.copyOf(values, values.length + 1);
        // newValues[values.length] = new int[]{35,  47,   8, 103,  83,  71,  11, 107,   9,  34,  41,  54,  73,
        //     72, 108, 100,  46,  27,  79,  98,  49,  63,  41, 116,  57,  86,
        //     51,  47,  88, 118,  65,   0,  64,  11,  45,  47,  36,  50, 114,
        //     90, 105,  55,  93,  12,  73,  96,  50,  27,  36,  97,  12,  21,
        //    107,  34, 106,  37,  84,  38, 110,  60,  34, 104,  92,  56,  94,
        //    109,  81,  17,  24, 106,  50,  68,  90,  73,  46,  99,   5,   5,
        //     22,  27,  58,  24,  20,  80,  37,   1,  16,  39,  26,  32,  12,
        //     47,  22,  28,  50,  95,   6, 105, 101,  20};
        // values = newValues;

        // int newCapacity[] = Arrays.copyOf(capacity, capacity.length + 1);
        // newCapacity[capacity.length] = 1000;
        // capacity = newCapacity;

        for (int i = 0; i < values.length; ++i) {
            System.out.print(i + 1);
            System.out.println(". We have a knapsack of capacity " + capacity[i] + " and we are given the following list of item values and weights:");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            System.out.println("Weights   |     Values");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            for (int j = 0; j < values[i].length; ++j)
                System.out.printf("%-10d|%6d\n", weights[i][j], values[i][j]);
            int result = findMaxKnapsackProfit(capacity[i], weights[i], values[i]);
            System.out.println("\nThe maximum we can earn is: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println();
        }
    }

    /*
        办法1：自顶向下的递归
     * 1. 创建二维数组dp，行数为物品价值(weight)的长度+1，列数为物品重量（capacity）+1
     * 2. 初始化dp的第一行和第一列为0
     * 3. 遍历weights，对于每一个物品，遍历dp的每一列，
     *      如果当前物品的重量小于等于当前列的重量，
     *          那么dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i])，
     *      否则dp[i][j] = dp[i-1][j]
     * 4. 返回dp的最后一个元素
     * 
        办法二：自底向上的动态规划
     * 1. 制作helper函数，参数为capacity, weights, values, dp, index
     * 2. 考虑三种情况
     *    1. 如果index == 0 || capacity == 0，返回0
     *   2. 如果weights[index] > capacity，返回helper(capacity, weights, values, dp, index - 1)
     *  3. 返回Math.max(helper(capacity, weights, values, dp, index - 1), values[index] + helper(capacity - weights[index], weights, values, dp, index - 1))
     * 3. 在主方法中创建二维数组dp，行数为物品价值(weight)的长度+1，列数为物品重量（capacity）+1
     * 4. 初始化dp的第一行和第一列为0
     * 5.调用helper函数，返回dp的最后一个元素
     * capacity: 背包的容量
     * weights: 物品的重量
     * values: 物品的价值
     * 
     */
    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        //创建一个二维数组，行数为有多少个物品+1， 列数为背包的容量+1（因为第一行和第一列是0）
        int[][] dp = new int[n + 1][capacity + 1];
        //初始化列表
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return findMaxKnapsackProfitHelper(capacity, weights, values,n, dp);
    }

    public static int findMaxKnapsackProfitHelper(int capacity, int[] weights, int[] values, int n, int[][] dp) {
        //base case
        if (n == 0 || capacity == 0) {
            return 0;
        }

        //如果已经解决过这个子问题，就直接返回子问题的解
        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        //如果当前重量<=背包的容量，那么我们可以选择放或者不放(Math.max)
        if(weights[n-1] <= capacity) {
            //在当前dp数组位置更新这个数
            dp[n][capacity] = Math.max(
                //不放
                findMaxKnapsackProfitHelper(capacity, weights, values, n-1, dp), 

                //放
                values[n-1] + 
                findMaxKnapsackProfitHelper(capacity - weights[n-1], weights, values, n-1, dp)
                
                );
                //这里的返回是因为，我们一定能更新一个具体的数字给dp数组，所以我们返回这个数字
                return dp[n][capacity];
        }

        //如果当前重量>背包的容量，那么我们只能选择不放
        dp[n][capacity] = findMaxKnapsackProfitHelper(capacity, weights, values, n-1, dp);  
        return dp[n][capacity];
    }
}
