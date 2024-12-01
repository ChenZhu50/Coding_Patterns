package Q2_02_Coin_change;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int[][] coins = {
                { 1, 3, 4 },
                { 1, 2, 3 },
                { 2, 3, 4, 5 },
                { 1, 4, 6, 9 },
                { 6, 7, 8 },
                { 1, 2, 3, 4, 5 },
                { 14, 15, 18, 20 } };
        int[] total = { 6, 5, 7, 11, 27, 41, 52 };
        for (int i = 0; i < total.length; i++) {
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " + total[i] + " from "
                    + Arrays.toString(coins[i]) + " is: " + coinChange(coins[i], total[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

    public static int coinChange(int[] coins, int total) {
        if (total < 1)
            return 0;
        int[] l = new int[total];
        // 初始化l数组,设置为max value是因为我们会用到0或者负数
        Arrays.fill(l, Integer.MAX_VALUE);
        return calculateMinimumCoins(coins, total, l);
    }

    public static int calculateMinimumCoins(int[] coins, int remainingAmount, int[] counter) {
        // base case: 如果<0 返回 -1，如果== 0 返回0
        int result = 0;

        if (remainingAmount < 0)
            return -1;

        if (remainingAmount == 0)
            return 0;

        // 使用记忆法，如果之前的存在了，就不需要反复计算了。
        if (counter[remainingAmount - 1] != Integer.MAX_VALUE) {
            return counter[remainingAmount - 1];
        }

        // 如果都不满足，则需要解决当前子问题
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            result = calculateMinimumCoins(coins, remainingAmount - coins[i], counter);

            //因为我们存在于一个for循环中，min的值会根据上一次的返回而更新。所以需要判断是不是之前有更小的min（min不会一直都是integer.max）
            if (result >= 0 && result < min) {
                min = 1 + result;
            }
            // 如果min != 了最大值，则肯定代表我们当前min是通过上一步得来的。更新到counter对应的位置就好
            if (min != Integer.MAX_VALUE) {
                counter[remainingAmount - 1] = min;
            } else { // 如果min还是最大值，则表示我们压根就没有找到一个合理的解，或者当前解>
                counter[remainingAmount - 1] = -1;
            }

        }
        return counter[remainingAmount - 1];
    }
}
