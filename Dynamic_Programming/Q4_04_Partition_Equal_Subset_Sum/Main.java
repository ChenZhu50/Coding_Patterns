package Q4_04_Partition_Equal_Subset_Sum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] input = {
                { 3, 1, 1, 2, 2, 1 },
                { 1, 3, 7, 3 }, { 1, 2, 3 },
                { 1, 2, 5 }, { 1, 3, 4, 8 },
                { 1, 2, 3, 2, 3, 5 },
                { 1, 5, 3, 2, 3, 19, 3 },
                { 1, 2, 3, 5, 3, 2, 1 }
        };

        for (int i = 0; i < input.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tGiven array: " + Arrays.toString(input[i]));
            Boolean result = canPartitionArray(input[i]);
            System.out.print("\n\tCan we partition the array into equal sum arrays?: " + result + "\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
    /*
     * 本题类似于背包问题的拿与不拿，我们需要考虑的是当拿取当前这个数字后，我们剩下的targer可否被拿取，如果可以，那么我们就可以拿取这个数字，如果不可以，
     * 那么我们就不拿取这个数字
     * 
     */

    public static Boolean canPartitionArray(int[] array) {
        // 首先查看array中的数字是否合为奇数：
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 因为需要使用dp，所以我们需要找到一个target，这个target就是sum/2
        int target = sum / 2;
        // 创建一个二维数组dp，dp[i][j] i代表数组的index，j代表target的值
        boolean[][] dp = new boolean[target + 1][array.length + 1];
        // 初始化dp第一行为true，因为当target为0时，我们可以不用取任何数就可以得到0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = false;
        }
        // 初始化第一列为false，因为当我们没有任何数时，我们无法得到任何target
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = true;
        }
        // 初始化dp数组00位置为true
        dp[0][0] = true;

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= array.length; j++) {
                // 如果array当前位置的值，已经比当前i（预期的target的值）还要大，就一定不会拿它。那么直接看它之前的一个格的位置的信息就好
                if (array[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                }
                // 如果小于的话，那么就需要看两个情况了。当前考虑的数值是（J-1）
                // 1.拿这个数（j-1），那么子问题变为当我的target是 target - （j-1）的时候，我是否可以解决这个问题:
                // dp[i-array[j-1]][j-1]（当我拿走这个数，且target减小对应值）
                // 2.如果不拿这个数的话，那么我能否凑到我的target： dp[i][j-1](当我不拿走target，且我不存在时，是否能凑够这个数字)
                else {
                    dp[i][j] = (dp[i][j - 1] || dp[i - (array[j-1])][j - 1]);
                }
            }

        }
        return dp[target][array.length];
    }

}
