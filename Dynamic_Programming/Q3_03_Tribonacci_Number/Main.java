package Q3_03_Tribonacci_Number;

import java.util.*;

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

	public static int findTribonacci(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return findTribonacciHelper(n, dp);

	}

	public static int findTribonacciHelper(int n, int dp[]) {
		// base case:
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		if (dp[n - 1] != -1) {
			return dp[n];
		}

		dp[n] = findTribonacciHelper(n - 1, dp) + findTribonacciHelper(n - 2, dp) + findTribonacciHelper(n - 3, dp);

		return dp[n];
	}
}
