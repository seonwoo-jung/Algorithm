package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main44 {

	private static long[] answer = new long[11];

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}})));
		System.out.println(Arrays.toString(solution(new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}})));
	}

	private static long[] solution(int[][] program) {
		// [프로그램 점수(우선순위), 호출시각, 실행시간]
		// 웨이트 힙은 우선순위 순서로 대기시킵니다.
		PriorityQueue<int[]> waitHeap = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		// 슬립 힙은 호출시각 순서로 대기시킵니다.
		PriorityQueue<int[]> sleepHeap = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1];
		});

		for (int i = 0; i < program.length; i++) {
			sleepHeap.add(program[i]);
		}

		run(waitHeap, sleepHeap);

		return answer;
	}

	private static void run(PriorityQueue<int[]> waitHeap, PriorityQueue<int[]> sleepHeap) {
		long time = -1;
		int run = 0;
		while (true) {
			// 슬립힙과 웨잇힙이 둘 다 비었고, 실행이 0이라면 끝난 것 입니다.
			if (waitHeap.isEmpty() && sleepHeap.isEmpty() && run == 0) {
				break;
			}
			time++;
			// 실행 중 이라면 감소, 즉 0이라면 실행 중 아님.
			if (run > 0) {
				run--;
			}

			// 호출
			// 시간이 같다면, 슬립 힙에서 꺼내서 대기열로 넣습니다.
			while (!sleepHeap.isEmpty() && sleepHeap.peek()[1] == time) {
				waitHeap.add(sleepHeap.poll());
			}

			// 실행
			if (run == 0 && !waitHeap.isEmpty()) {
				int[] curProgram = waitHeap.poll();
				// 실행시간에 추가합니다.
				run += curProgram[2];
				// 정답에는 실행된 시각 - 대기열에 들어간 시각이 기록됩니다.
				// 주의할 점은 프로그램 별로 저장되는게 아니라 우선순위 별로 기록된다는 것 입니다.
				// ex) 우선순위가 1인 프로그램은 answer[1]에 저장됨.
				answer[curProgram[0]] += time - curProgram[1];
			}
		}
		// 0번에는 프로그램의 총 시간이 들어갑니다.
		answer[0] = time;
	}
}