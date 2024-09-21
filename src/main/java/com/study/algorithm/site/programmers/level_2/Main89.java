package com.study.algorithm.site.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Main89 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][][] visited;
	private static int N, M;
	private static int answer;

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"OOS", "EOO", "LOO"}));
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.printf("%5b ", visited[j][k][i]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println(solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.printf("%5b ", visited[j][k][i]);
				}
				System.out.println();
			}
			System.out.println();
		}
//		System.out.println(solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
//		System.out.println(solution2(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
//		System.out.println(solution2(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
	}

	private static int solution(String[] maps) {
		int answer = -1;
		N = maps.length;
		M = maps[0].length();

		visited = new boolean[N][M][2];
		char[][] map = new char[N][M];
		Board start = null;

		for (int i = 0; i < N; i++) {
			char[] chars = maps[i].toCharArray();
			for (int j = 0; j < chars.length; j++) {
				map[i][j] = chars[j];
				if (chars[j] == 'S') {
					start = new Board(i, j, false);
				}
			}
		}

		Queue<Board> Q = new LinkedList<>();
		visited[start.x][start.y][0] = true;
		Q.offer(start);
		int L = 0;

		while (!Q.isEmpty()) {
			int len = Q.size();

			for (int i = 0; i < len; i++) {
				Board cur = Q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 'X') {
						boolean leverPulled = cur.isLebber || (map[nx][ny] == 'L'); // 레버 상태 갱신
						int leverStatus = leverPulled ? 1 : 0; // 레버를 당긴 상태로 인덱싱

						if (!visited[nx][ny][leverStatus]) {
							if (map[nx][ny] == 'E' && leverPulled) {
								return L + 1;
							}
							visited[nx][ny][leverStatus] = true;
							Q.offer(new Board(nx, ny, leverPulled));
						}
					}
				}
			}
			L++;
		}
		return answer;
	}

	private static int solution2(String[] maps) {
		N = maps.length;
		M = maps[0].length();
		answer = Integer.MAX_VALUE;

		visited = new boolean[N][M][2];
		char[][] map = new char[N][M];
		Board start = null;

		for (int i = 0; i < N; i++) {
			char[] chars = maps[i].toCharArray();
			for (int j = 0; j < chars.length; j++) {
				map[i][j] = chars[j];
				if (chars[j] == 'S') {
					start = new Board(i, j, false);
				}
			}
		}

		visited[start.x][start.y][0] = true;
		DFS(0, start.x, start.y, false, map);

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	private static void DFS(int L, int x, int y, boolean isLebber, char[][] map) {
		if (map[x][y] == 'E' && isLebber) {
			answer = Math.min(L, answer);
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 'X') {
					boolean leverStatus = isLebber || (map[nx][ny] == 'L'); // 레버 상태 갱신
					int lever = leverStatus ? 1 : 0;

					if (!visited[nx][ny][lever]) {
						visited[nx][ny][lever] = true;
						DFS(L + 1, nx, ny, leverStatus, map);
						visited[nx][ny][lever] = false;
					}
				}
			}
		}
	}

	private static class Board {
		int x, y;

		boolean isLebber;
		public Board(int x, int y, boolean isLebber) {
			this.x = x;
			this.y = y;
			this.isLebber = isLebber;
		}
	}
}