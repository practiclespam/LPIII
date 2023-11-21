package DAA4;

import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int level;
	int profit;
	int weight;
	double bound;

	public Node(int level, int profit, int weight, double bound) {
		this.level = level;
		this.profit = profit;
		this.weight = weight;
		this.bound = bound;
	}

	@Override
	public int compareTo(Node other) {
		return Double.compare(other.bound, this.bound);
	}
}

public class KnapsackBranchAndBound {

	private static double calculateBound(int level, int weight, int value, int[] weights, int[] values, int capacity) {
		double bound = value;
		int currentWeight = weight;
		for (int i = level + 1; i < weights.length; i++) {
			if (currentWeight + weights[i] <= capacity) {
				// Include the entire item if it fits in the remaining capacity
				bound += values[i];
				currentWeight += weights[i];
			} else {
				// Stop the loop if the remaining capacity cannot accommodate the entire item
				break;
			}
		}

		return bound;
	}

	public static int knapsack(int capacity, int[] weights, int[] values) {
		int n = weights.length;
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

		priorityQueue.add(new Node(-1, 0, 0, 0.0));

		int maxProfit = 0;

		while (!priorityQueue.isEmpty()) {
			Node u = priorityQueue.poll();

			if (u.level == n - 1) {
				continue;
			}

			int nextLevel = u.level + 1;

			// Include the next item
			int nextWeightInclude = u.weight + weights[nextLevel];
			int nextProfitInclude = u.profit + values[nextLevel];

			double boundInclude = calculateBound(nextLevel, nextWeightInclude, nextProfitInclude, weights, values,
					capacity);

			if (nextWeightInclude <= capacity && boundInclude > maxProfit) {
				maxProfit = nextProfitInclude;
			}

			if (boundInclude > maxProfit) {
				priorityQueue.add(new Node(nextLevel, nextProfitInclude, nextWeightInclude, boundInclude));
			}

			// Exclude the next item
			double boundExclude = calculateBound(nextLevel, u.weight, u.profit, weights, values, capacity);

			if (boundExclude > maxProfit) {
				priorityQueue.add(new Node(nextLevel, u.profit, u.weight, boundExclude));
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		int capacity = 6;
		int[] values = { 10, 12, 28 };
		int[] weights = { 1, 2, 4 };

		int maxValue = knapsack(capacity, weights, values);
		System.out.println("Maximum value using Branch and Bound: " + maxValue);
	}
}
