package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

/**
 * 입국심사
 */
public class Main96 {

	public static void main(String[] args) {
		long solution = solution(6, new int[]{7, 10});
		System.out.println(solution);
	}

	private static long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);

		// 이분탐색을 위한 범위 설정
		long lt = 0;
		long rt = times[times.length - 1] * (long) n;

		while (lt <= rt) {
			long mid = (lt + rt) / 2;
			long complete = 0;

			for (int i = 0; i < times.length; i++) {
				complete += mid / times[i];
			}

			// 해당 시간에는 모든 사람이 검사받을 수 없다.
			if (complete < n) {
				lt = mid + 1;
			} else {
				rt = mid - 1;
				// 모두 검사받았으나, 더 최솟값이 있을 수 있다.
				answer = mid;
			}
		}
		return answer;
	}
}