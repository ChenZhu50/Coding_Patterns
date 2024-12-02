package Q5_05_Counting_Bits;

public class Main {
    public static void main(String[] args) {
        int[] inputBits = {  10 };

        for (int i = 0; i < inputBits.length; ++i) {
            System.out.println((i + 1) + ".\t Bits: " + inputBits[i]);
            int[] result = countingBits(inputBits[i]);
            System.out.println("\t Counting bits: " + java.util.Arrays.toString(result));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }

    //todo:
    /* 
     * 1. 创造一个长度 = n+1的数组
     * 2. base case = 0的时候 = 0，1的时候 = 1， 2的时候 = 1
     * 3. 因为一个数字/2时 在二进制表达中1的个数一定于 数字一致
     *      3.1 比如16（1000） 和 8 （0100）
     *      所以我们可以，当前数字/2 + 1如果是奇数
     *      偶数：当前数字/2
     * 
    */
    public static int[] countingBits(int n) {
        int[] dp = new int[n+1];
        if(n == 0) return dp;

        dp[0] = 0;
        dp[1] = 1;
        //这里使用++i是因为我们要从2开始，所以第一次进来就需要是3
        for(int i = 2; i <= n; ++i){
            if(i%2 != 0){
                dp[i] = dp[i/2] + 1;
            }else{
                dp[i] = dp[i/2];
            }
        }
        
        return dp;
    }
}
