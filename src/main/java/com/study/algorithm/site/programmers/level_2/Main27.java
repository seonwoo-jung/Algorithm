package com.study.algorithm.site.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Main27 {

	public static void main(String[] args) {
		int[][] maps = {
			{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 1},
			{0, 0, 0, 0, 1}
		};
		System.out.println(solution(maps));

		int[][] maps2 = {
			{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 0},
			{0, 0, 0, 0, 1}
		};
		System.out.println(solution(maps2));
	}

	private static int solution(int[][] maps) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		int[][] visited = new int[maps.length][maps[0].length];

		Queue<Node> Q = new LinkedList<>();
		visited[0][0] = 1;
		Q.offer(new Node(0, 0));

		while (!Q.isEmpty()) {

			Node cur = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
					continue;
				}

				if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[cur.x][cur.y] + 1;
					Q.offer(new Node(nx, ny));
				}

			}
		}

		int answer = visited[maps.length - 1][maps[0].length - 1];
		return answer == 0 ? -1 : answer;
	}

	private static class Node {

		public int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
