package com.study.algorithm.inflearn.middle.ch08_graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main4_방향바꾸기 {

	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int[][] cost;

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
		System.out.println(solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
		System.out.println(solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
		System.out.println(solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
		System.out.println(solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
	}

	private static int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		int m = board[0].length;
		cost = new int[n][m];

		for (int i = 0; i < cost.length; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		cost[0][0] = 0;

		Queue<int[]> PQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		// x, y, 화살표 바꾼 횟수
		PQ.offer(new int[]{0, 0, 0});

		while (!PQ.isEmpty()) {
			int[] cur = PQ.poll();
			int dir = board[cur[0]][cur[1]] - 1;

			// 더 큰 값으로 탐색할 필요 X
			if (cur[2] > cost[cur[0]][cur[1]]) continue;

			for (int k = 0; k < 4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				// 화살표를 바꿀 필요가 없음
				if (k == dir && cost[nx][ny] > cur[2]) {
					cost[nx][ny] = cur[2];
					PQ.offer(new int[]{nx, ny, cur[2]});
				} else {
					if (cost[nx][ny] > cur[2] + 1) {
						cost[nx][ny] = cur[2] + 1;
						PQ.offer(new int[]{nx, ny, cur[2] + 1});
					}
				}
			}
		}
		return cost[n - 1][m - 1];
	}
}
