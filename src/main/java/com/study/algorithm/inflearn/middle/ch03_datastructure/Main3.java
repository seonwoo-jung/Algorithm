package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 현관문 출입 순서
public class Main3 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
		System.out.println(Arrays.toString(solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
		System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
	}

	private static int[] solution(int[] arrival, int[] state) {
		Queue<Integer> enter = new LinkedList<>(); // 현관문을 이용해 들어오기 위해
		Queue<Integer> exit = new LinkedList<>(); // 현관문을 이용해 나가기 위해

		int n = arrival.length, prev = 1;

		int[] answer = new int[n];

		// cnt: 현관문을 사용한 사람 수
		// i: 사원번호

		for (int t = 0, i = 0, cnt = 0; ; t++) {
			// 출입
			if (enter.isEmpty() && exit.isEmpty() && i < n) {
				if (t < arrival[i]) {
					t = arrival[i]; // 건너뛰기
					prev = 1;
				}
			}

			while (i < n && arrival[i] <= t) {
				if (state[i] == 0) {
					enter.offer(i);
				} else {
					exit.offer(i);
				}
				i++;
			}

			if (prev == 1) {
				// 나가는 사원 우선
				if (!exit.isEmpty()) {
					answer[exit.poll()] = t;
					prev = 1;
				} else {
					answer[enter.poll()] = t;
					prev = 0;
				}
			} else if (prev == 0) {
				if (!enter.isEmpty()) {
					answer[enter.poll()] = t;
					prev = 0;
				} else {
					answer[exit.poll()] = t;
					prev = 1;
				}
			}
			cnt++;

			// 현관문 사용한 사람 수 == 사원수가 참일 때 for문을 끝내줌
			if (cnt == n) {
				break;
			}
		}
		return answer;
	}
}