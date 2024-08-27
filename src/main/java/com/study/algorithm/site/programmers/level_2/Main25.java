package com.study.algorithm.site.programmers.level_2;

public class Main25 {

	private static int answer = 0;

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
	}

	private static int solution(int[] numbers, int target) {
		DFS(0, 0, target, numbers);
		return answer;
	}

	private static void DFS(int L, int sum, int target, int[] numbers) {
		if (L == numbers.length) {
			if (sum == target) {
				answer++;
			}
		} else {
			DFS(L + 1, sum + numbers[L], target, numbers);
			DFS(L + 1, sum - numbers[L], target, numbers);
		}
	}
}
