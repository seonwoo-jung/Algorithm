package com.study.algorithm.site.programmers.level_2;

/**
 * 타겟넘버
 */
public class Main97 {

	public static void main(String[] args) {
		int solution = solution(new int[]{1, 1, 1, 1, 1}, 3);
		System.out.println(solution);

		int solution2 = solution(new int[]{4, 1, 2, 1}, 4);
		System.out.println(solution2);
	}

	private static int solution(int[] numbers, int target) {
		return DFS(0, 0, numbers, target);
	}

	private static int DFS(int L, int sum, int[] numbers, int target) {
		if (L == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}
		return DFS(L + 1, sum + numbers[L], numbers, target) + DFS(L + 1, sum - numbers[L], numbers, target);
	}
}