package com.study.algorithm.inflearn.middle.ch04_sorting;

import java.util.Arrays;

/**
 * 멀티태스킹
 */
public class Main6_멀티태스킹 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 2, 3}, 5));
		System.out.println(solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
		System.out.println(solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
	}

	private static int solution(int[] tasks, long k) {
		int[] sT = new int[tasks.length + 1];
		System.arraycopy(tasks, 0, sT, 1, tasks.length); // tasks 배열의 0번 인덱스부터 st에 1번 인덱스부터 시작해서 tasks의 길이만큼 복사한다.
		Arrays.sort(sT);

		int rest = tasks.length; // 작업 개수

		for (int i = 1; i < sT.length; i++) {
			long time = ((long) rest * (sT[i] - sT[i - 1])); // 작업이 끝나는데 걸리는 순간을 계산하는 로직

			if (k < time) {
				long idx = k % rest;
				int cnt = 0;
				for (int j = 0; j < tasks.length; j++) {
					if (tasks[j] >= sT[i]) {
						if (cnt == idx) {
							return j + 1;
						}
						cnt++;
					}
				}
			} else {
				k -= time;
				rest--;
			}
		}
		return -1;
	}
}
