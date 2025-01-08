package com.study.algorithm.inflearn.middle.ch08_graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main3_벽허물기 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] cost;

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
	}

	private static int solution(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		cost = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}

		cost[0][0] = 0;
		// 우선순위 큐로 인해서 벽을 적게 부순 경로를 먼저 탐색한다.
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

		// x, y, 벽을 부순 개수
		PQ.add(new int[]{0, 0, 0});

		while (!PQ.isEmpty()) {
			int[] cur = PQ.poll();

			// 탐색하려는 대상이 벽을 부순 개수가 많으면 탐색할 필요 X
			if (cur[2] > cost[cur[0]][cur[1]]) continue;

			// 레벨탐색 시작
			for (int k = 0; k < 4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];

				// 격자 밖 continue
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

				if (board[nx][ny] == 0 && cost[nx][ny] > cur[2]) {
					cost[nx][ny] = cur[2];
					PQ.offer(new int[]{nx, ny, cur[2]});
				} else if (board[nx][ny] == 1 && cost[nx][ny] > cur[2] + 1) {
					cost[nx][ny] = cur[2] + 1;
					PQ.offer(new int[]{nx, ny, cur[2] + 1});
				}
			}
		}
		return cost[n - 1][m - 1];
	}
}
