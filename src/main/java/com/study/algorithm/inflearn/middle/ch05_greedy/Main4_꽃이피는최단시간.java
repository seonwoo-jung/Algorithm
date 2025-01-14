package com.study.algorithm.inflearn.middle.ch05_greedy;

import java.util.Arrays;

/**
 * 꽃이 피는 최단시간
 */
public class Main4_꽃이피는최단시간 {

	public static void main(String[] args){
		System.out.println(solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
		System.out.println(solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
		System.out.println(solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
		System.out.println(solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
		System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
	}

	private static int solution(int[] plantTime, int[] growTime) {
		int answer = 0;
		int n = plantTime.length;
		int[][] list = new int[n][2];

		for (int i = 0; i < n; i++) {
			list[i][0] = plantTime[i];
			list[i][1] = growTime[i];
		}

		// 자라는데 오래걸리는 순으로 정렬
		Arrays.sort(list, (a, b) -> b[1] - a[1]);

		int start = 0, end = 0;

		for (int[] x : list) {
			// 심는데 걸리는 시간, 자라는데 걸리는 시간
			end = start + x[0] + x[1];
			answer = Math.max(answer, end);
			start += x[0];
		}

		return answer;
	}
}
