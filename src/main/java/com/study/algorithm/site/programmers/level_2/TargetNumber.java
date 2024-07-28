package com.study.algorithm.site.programmers.level_2;

public class TargetNumber {

	static int answer = 0;

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		DFS(0, 0, numbers, target);
		System.out.println("answer = " + answer);
	}

	static void DFS(int L, int sum, int[] numbers, int target) {
		if (L == numbers.length) {
			if (target == sum) answer++;
		} else {
			DFS(L + 1, sum + numbers[L], numbers, target);
			DFS(L + 1, sum - numbers[L], numbers, target);
		}
	}
}
