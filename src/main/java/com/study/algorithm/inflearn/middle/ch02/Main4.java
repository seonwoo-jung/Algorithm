package com.study.algorithm.inflearn.middle.ch02;

/**
 * 서로 다른 빈도수 만들기
 */
public class Main4 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
		System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
		System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
		System.out.println(solution(new int[]{-1, 0, 1}, 0));
		System.out.println(solution(new int[]{-1, -1, -1, 1}, 0));
	}

	private static int solution(int[] nums, int m) {
		int answer = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int sum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (sum == m) {
					answer++;
				}
				sum += nums[j];
			}
		}
		return answer;
	}
}
