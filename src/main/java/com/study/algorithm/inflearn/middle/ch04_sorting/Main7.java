package com.study.algorithm.inflearn.middle.ch04_sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * 멀티태스킹
 */
public class Main7 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
		System.out.println(solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
		System.out.println(solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
		System.out.println(solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
	}

	private static int solution(int[][] meetings) {
		List<int[]> list = new ArrayList<>();

		for (int[] x : meetings) {
			list.add(new int[]{x[0], 1});
			list.add(new int[]{x[1], 2});
		}

		// 빨리 시작하는 순으로 정렬하고, 동일하다면 끝나는 시간이 먼저 오도록
		list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		int answer = 0, cnt = 0;

		for (int[] x: list) {
			if (x[1] == 1) {
				cnt++;
			} else {
				cnt--;
			}
			answer = Math.max(answer, cnt);
		}

		return answer;
	}
}
