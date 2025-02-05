package com.study.algorithm.book.codingtest_learn.ch11;

import java.util.ArrayDeque;

public class Main39 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	static char[][] map;

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
		System.out.println(solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
	}

	private static int solution(String[] maps) {
		N = maps.length;
		M = maps[0].length();
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = maps[i].toCharArray();
		}

		Point start = null, end = null, lever = null;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'S') {
					start = new Point(j, i);
				} else if (map[i][j] == 'E') {
					end = new Point(j, i);
				} else if (map[i][j] == 'L') {
					lever = new Point(j, i);
				}
			}
		}

		int startLever = BFS(start, lever);
		int leverEnd = BFS(lever, end);

		if (startLever == -1 || leverEnd == -1) {
			return -1;
		} else {
			return startLever + leverEnd;
		}
	}

	private static int BFS(Point start, Point end) {
		int[][] dist = new int[N][M];
		ArrayDeque<Point> queue = new ArrayDeque<>();
		dist[start.ny][start.nx] = 1;
		queue.add(start);

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.nx + dx[i];
				int ny = now.ny + dy[i];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
					continue;
				}

				if (dist[ny][nx] > 0) {
					continue;
				}

				if (map[ny][nx] == 'X') {
					continue;
				}

				dist[ny][nx] = dist[now.ny][now.nx] + 1;

				queue.add(new Point(nx, ny));

				if (nx == end.nx && ny == end.ny) {
					return dist[end.ny][end.nx] - 1;
				}
			}
		}
		return -1;
	}

	private static class Point {

		int nx, ny;

		public Point(int nx, int ny) {
			this.nx = nx;
			this.ny = ny;
		}
	}
}
