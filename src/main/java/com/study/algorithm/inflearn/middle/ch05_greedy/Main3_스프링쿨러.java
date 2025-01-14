package com.study.algorithm.inflearn.middle.ch05_greedy;

import java.util.Arrays;

/**
 * 스프링쿨러
 */
public class Main3_스프링쿨러 {

	public static void main(String[] args){
		System.out.println(solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
		System.out.println(solution(4, new int[]{1, 2, 2, 0, 0}));
		System.out.println(solution(5, new int[]{2, 0, 0, 0, 0, 2}));
		System.out.println(solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
	}

	private static int solution(int n, int[] nums) {
		int answer = 0;
		int[][] lines = new int[nums.length][2];

		// 각 스프링쿨러의 범위를 구한 것
		for (int i = 0; i < n; i++) {
			// 스프링 쿨러 시작지점, 끝지점
			lines[i][0] = Math.max(0, i - nums[i]);
			lines[i][1] = Math.min(n, i + nums[i]);
		}

		// 시작지점을 기준으로 오름차순 정렬
		Arrays.sort(lines, (o1, o2) -> o1[0] - o2[0]);

		int s = 0, e = 0, i = 0;

		while (i < lines.length) {
			// start 지점부터 가장 길게 스프링쿨러를 뿌릴 수 있는 스프링쿨러를 찾는 while문
			while (i < lines.length && lines[i][0] <= s) {
				e = Math.max(e, lines[i][1]);
				i++;
			}
			answer++;
			if (e == n) return answer;
			if (s == e) return -1;
			s = e;
		}

		return answer;
	}
}
