package SlidingWindow.Q3_Best_time_to_buy_and_sell_stock;

public class Main {
    public static void main(String[] args) {
        // Test case
        int[] prices = {7, 1, 5, 3, 6, 4}; // Expected output: 5
        int result = maxProfit(prices);
                System.out.println("Test Case 1: Expected output: 5, Actual output: " + result);
        
                // Additional test case
                int[] prices2 = {8, 3, 2, 6, 5, 9}; // Expected output: 7 (buy at 2, sell at 9)
                int result2 = maxProfit(prices2);
                System.out.println("Test Case 2: Expected output: 7, Actual output: " + result2);
        
                // Edge case with no profit
                int[] prices3 = {7, 6, 4, 3, 1}; // Expected output: 0 (prices only decrease)
                int result3 = maxProfit(prices3);
                System.out.println("Test Case 3: Expected output: 0, Actual output: " + result3);
    }

    private static int maxProfit(int[] prices) {
        
        /*
         * 1. 初始化buy和sell指针 为0和1
         * 2. 遍历price中的sell指针，计算利润 用price[sell] - price[buy]
         * 3. 如果price[sell] > price[buy] 则当前可以卖出，则用math来比较是否是最大的利润
         *  3.1 但如果price[sell] < price[buy] 那么此时sell的时候buy是更合适的，我们把buy更新为sell。
         * 4.一旦sell到达了末尾，我们就返回最大利润
         */

        // 1. 初始化
        int buy = 0;
        int sell = 0;
        int maxPrice = 0;

        //如果price里面只有一个元素，我们就返回0，因为根本无法买卖
        if (prices.length == 1) {
            return 0;
        }

        //2. 遍历指针
        for(int i =0; i < prices.length; i++){
            sell = i;
            if(prices[buy] < prices[sell]){
                maxPrice = Math.max(maxPrice, (prices[sell]-prices[buy]));
            }else{
                buy = sell;
            }
        }

        return maxPrice;
    }
}
