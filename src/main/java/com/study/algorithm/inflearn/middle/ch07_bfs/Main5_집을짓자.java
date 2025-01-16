package com.study.algorithm.inflearn.middle.ch07_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Main5_집을짓자 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
		System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
		System.out.println(solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
		System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
	}

	private static int solution(int[][] board) {
		int answer = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int n = board.length;
		// 모든 빌딩에서 빈땅으로 가는 이동거리의 총합
		int[][] dist = new int[n][n];
		Queue<int[]> Q = new LinkedList<>();
		int emptyLand = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					answer = Integer.MAX_VALUE;
					Q.offer(new int[]{i, j});
					int L = 0;

					while (!Q.isEmpty()) {
						L++;
						int len = Q.size();
						// 큐에 있는 노드들을 전부 꺼낸다.
						for (int r = 0; r < len; r++) {
							int[] cur = Q.poll();
							for (int k = 0; k < 4; k++) {
								int nx = cur[0] + dx[k];
								int ny = cur[1] + dy[k];
								if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand) {
									board[nx][ny]--;
									dist[nx][ny] += L;
									Q.offer(new int[]{nx, ny});
									answer = Math.min(answer, dist[nx][ny]);
								}
							}
						}
					}

					emptyLand--;
				}
			}
		}
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
}
