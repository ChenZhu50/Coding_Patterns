package Q3_03_Tribonacci_Number;

//import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] inputList = { 4, 5, 25 };
		int index = 0;
		for (int input : inputList) {
			System.out.println((++index) + ". The " + input + "th Tribonacci number is:  "
					+ findTribonacci(input));
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}
	/*
	 * Solution one:
	 * public static int findTribonacci(int n) {
	 * int[] dp = new int[n + 1];
	 * Arrays.fill(dp, -1);
	 * return findTribonacciHelper(n, dp);
	 * 
	 * }
	 * 
	 * public static int findTribonacciHelper(int n, int dp[]) {
	 * // base case:
	 * if (n == 0)
	 * return 0;
	 * if (n == 1)
	 * return 1;
	 * if (n == 2)
	 * return 1;
	 * if (dp[n - 1] != -1) {
	 * return dp[n];
	 * }
	 * 
	 * dp[n] = findTribonacciHelper(n - 1, dp) + findTribonacciHelper(n - 2, dp) +
	 * findTribonacciHelper(n - 3, dp);
	 * 
	 * return dp[n];
	 * }
	 */

	// solution 2: replace:

	public static int findTribonacci(int n) {
		// base case:
		if (n < 3)
			// 只有当 n = 0 时，我们才会返回0，如果是1或者2都是返回1的
			return n == 0 ? 0 : 1;

		int first = 0, second = 1, third = 1;
		int temp = 0;

		// 之后，我们只需要替换就好了，因为我们也并没有需要前面的数字，只是简单的当前三个数字相加而已。
		for (int i = 3; i < n; i++) {
			temp = first + second + third;
			first = second;
			second = third;
			third = temp;
		}
		return temp;
	}
}
