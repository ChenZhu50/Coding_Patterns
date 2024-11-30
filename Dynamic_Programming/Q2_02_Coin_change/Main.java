package Q2_02_Coin_change;

import java.util.Arrays;

public class Main {
    public static void main( String args[] ) {
        int [][] coins = {{2, 3, 4, 5}, 
            {1, 4, 6, 9}, 
            {6, 7, 8}, 
            {1, 2, 3, 4, 5}, 
            {14, 15, 18, 20}};
        int [] total = {7, 11, 27, 41, 52};
        for (int i = 0; i < total.length; i++)
        {
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " + total[i] + " from " + Arrays.toString(coins[i]) + " is: "+ coinChange(coins[i], total[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        
    }
    public static int coinChange(int [] coins, int total)
    {
        if(total < 1)
            return 0;
        int [] l = new int[total];
        //初始化l数组,设置为max value是因为我们会用到0或者负数
        Arrays.fill(l, Integer.MAX_VALUE);
        return calculateMinimumCoins(coins, total, l);
    }

    public static int calculateMinimumCoins(int [] coins, int remainingAmount, int [] counter)
    {   
        int result = 0;
        //base case
        //1. 当remainingAmount为0时，返回0
        //2. 当remainingAmount小于0时，返回-1
        if(remainingAmount == 0)
            return 0;
        if(remainingAmount < 0)
            return -1;
        //查找我是否已经解决过这个子问题,使用remainingAmount -1是因为数组是从0开始的
        if(counter[remainingAmount -1] != Integer.MAX_VALUE)
            return counter[remainingAmount -1];

        //如果子问题没有被解决过，那么我们就要解决这个子问题
        //min = Integer.MAX_VALUE是为了找到最小的硬币数量
        int min = Integer.MAX_VALUE;
        for(int i =0; i < coins.length; i++)
        {
            result = calculateMinimumCoins(coins, remainingAmount-coins[i], counter);
            if (result >= 0 && result < min) {  
                min = 1+result;
            }
            if(min != Integer.MAX_VALUE){
                counter[remainingAmount - 1] = min;
            }else{
                counter[remainingAmount -1] = -1;
            }
        }

        return counter[remainingAmount - 1];
    }

}
