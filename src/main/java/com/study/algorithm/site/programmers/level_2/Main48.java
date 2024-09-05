package com.study.algorithm.site.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Main48 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, -1, 0, 1};
	private static int[] dx2 = {-2, 0, 2, 0};
	private static int[] dy2 = {0, -2, 0, 2};
	private static int N, M, answer;
	private static boolean[][] map;
	private static boolean[][][] visit;

	public static void main(String[] args) {
		System.out.println(solution(4, 4, new int[][]{{2, 3}, {3, 3}}));
		System.out.println(solution(5, 4, new int[][]{{1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}}));
	}

	private static int solution(int n, int m, int[][] hole) {
		N = m;
		M = n;
		map = new boolean[N][M];
		for (int i = 0; i < hole.length; i++) {
			int a = N - hole[i][1];
			int b = hole[i][0] - 1;
			map[a][b] = true;
		}

		answer = -1;
		visit = new boolean[N][M][2];
		BFS(N - 1, 0);
		//보물 위치는 0,M-1
		return answer;
	}

	private static void BFS(int x, int y) {
		visit[x][y][0] = true;
		Queue<Node> Q = new LinkedList<>();
		Q.offer(new Node(x, y, 0, 0));

		while (!Q.isEmpty()) {
			Node cur = Q.poll();
			if (cur.x == 0 && cur.y == M - 1) {
				answer = cur.time;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny][cur.use]) {
					if (!map[nx][ny]) { //함정 칸이 아니라면
						visit[nx][ny][cur.use] = true;
						Q.offer(new Node(nx, ny, cur.use, cur.time + 1));
					}
				}
			}

			//아직 신발을 사용하지 않았다면
			if (cur.use == 0) {
				for (int k = 0; k < 4; k++) {
					int nx = cur.x + dx2[k];
					int ny = cur.y + dy2[k];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny][cur.use + 1]) {
						if (!map[nx][ny]) {
							visit[nx][ny][cur.use + 1] = true;
							Q.offer(new Node(nx, ny, cur.use + 1, cur.time + 1));
						}
					}
				}
			}
		}
	}

	private static class Node {

		int x, y, use, time;

		public Node(int x, int y, int use, int time) {
			this.x = x;
			this.y = y;
			this.use = use;
			this.time = time;
		}
	}
}
