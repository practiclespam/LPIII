package DAA4;

public class KsnapProblem01DP {
	public static int knapsackDP(int capacity, int[] weights, int[] values, int n) {
		int[][] dp = new int[n + 1][capacity + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= capacity; w++) {
				if (i == 0 || w == 0) {
					dp[i][w] = 0;
				} else if (weights[i - 1] > w) {
					dp[i][w] = dp[i - 1][w];
				} else {
					dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
				}
			}
		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < capacity + 1; j++) {
				System.out.print(" " + dp[i][j]);
			}
			System.out.println();
		}
		return dp[n][capacity];
	}

	public static void main(String[] args) {
		int[] values = { 10, 12, 28 };
		int[] weights = { 1, 2, 4 };
		int capacity = 6;
		int n = values.length;

		int maxValue = knapsackDP(capacity, weights, values, n);
		System.out.println("Maximum value: " + maxValue);
	}
}