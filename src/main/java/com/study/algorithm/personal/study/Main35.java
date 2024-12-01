package com.study.algorithm.personal.study;
import java.util.*;
/**
 * DFS
 */
public class Main35 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = kb.nextInt();
			}
		}

		int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

		List<int[]> record = new ArrayList<>();
		Queue<Point> Q = new LinkedList<>();
		int r = kb.nextInt();
		int c = kb.nextInt();

		Q.offer(new Point(r - 1, c - 1));
		int cnt = 0;

		while (!Q.isEmpty()) {
			Point cur = Q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] == 0) {
					graph[nx][ny] = 1;
					System.out.println("nx = " + nx);
					System.out.println("ny = " + ny);
					record.add(new int[]{nx, ny});
					Q.offer(new Point(nx, ny));
					cnt++;
				}
			}
		}
		int[][] answer = new int[n][n];
		for (int[] ans : record) {
			answer[ans[0]][ans[1]] = 1;
		}

		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				System.out.printf("%d ", answer[i][j]);
			}
			System.out.println();
		}

	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
