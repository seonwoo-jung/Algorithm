package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// CPU 스케줄링
public class Main5 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
		System.out.println(Arrays.toString(solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
		System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
		System.out.println(Arrays.toString(solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
	}

	private static int[] solution(int[][] tasks) {
		int n = tasks.length;
		int[] answer = new int[n];
		int idx = 0;
		LinkedList<int[]> programs = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			// 호출시간, 실행시간, 작업번호
			programs.add(new int[]{tasks[i][0], tasks[i][1], i});
		}

		// 호출시간별로 정렬
		programs.sort(Comparator.comparingInt(a -> a[0]));

		// 호출시간으로 정렬, 같은경우 실행시간으로 정렬 (오름차순)
		Queue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int fT = 0;

		while (!programs.isEmpty() || !PQ.isEmpty()) {

			if (PQ.isEmpty()) {
				// 현재시간과 호출시간의 공백이 길 때 확 건너뛰는 것으로 피부과와 동일함
				fT = Math.max(fT, programs.peek()[0]);
			}

			// fT보다 작은 작업들은 PQ에 삽입한다.
			while (!programs.isEmpty() && programs.peek()[0] <= fT) {
				int[] x = programs.pollFirst();
				PQ.add(new int[]{x[1], x[2]});
			}

			int[] ex = PQ.poll();

			fT = fT + ex[0]; // fT + 작업시간
			answer[idx++] = ex[1]; // 작업번호
		}

		return answer;
	}
}
