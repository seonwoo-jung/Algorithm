package com.study.algorithm.inflearn.middle.ch08_graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main5_공굴리기 {

	public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
		System.out.println(solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
	}

	private static int solution(int[][] board, int[] s, int[] e) {
		int n = board.length;
		int m = board[0].length;
		int[][] cost = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}

		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		PQ.add(new int[]{s[0], s[1], 0});
		cost[s[0]][s[1]] = 0;

		while (!PQ.isEmpty()) {
			int[] cur = PQ.poll();

			if (cur[2] > cost[cur[0]][cur[1]]) continue;

			for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
				int nx = cur[0];
				int ny = cur[1];
				int len = cur[2];
				while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
					nx += dir[0];
					ny += dir[1];
					len++;
				}
				nx -= dir[0];
				ny -= dir[1];
				len--;
				if (cost[nx][ny] > len) {
					cost[nx][ny] = len;
					PQ.add(new int[]{nx, ny, len});
				}
			}
		}
		if (cost[e[0]][e[1]] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return cost[e[0]][e[1]];
		}
	}
}
