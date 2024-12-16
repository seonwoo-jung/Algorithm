package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.ArrayList;
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
		ArrayList<Integer> res = new ArrayList<>();
		LinkedList<int[]> programs = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			programs.add(new int[]{tasks[i][0], tasks[i][1], i});
		}

		programs.sort(Comparator.comparingInt(a -> a[0]));
		Queue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int fT = 0;

		while (!programs.isEmpty() || !PQ.isEmpty()) {
			if (PQ.isEmpty()) {
				fT = Math.max(fT, programs.peek()[0]);
			}
			while (!programs.isEmpty() && programs.peek()[0] <= fT) {
				int[] x = programs.pollFirst();
				PQ.add(new int[]{x[1], x[2]});
			}
			int[] ex = PQ.poll();
			fT = fT + ex[0];
			res.add(ex[1]);
		}

		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			answer[i] = res.get(i);
		}

		return answer;
	}
}
