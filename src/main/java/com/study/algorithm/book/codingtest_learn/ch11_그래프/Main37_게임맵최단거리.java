package com.study.algorithm.book.codingtest_learn.ch11_그래프;

import java.util.ArrayDeque;

public class Main37_게임맵최단거리 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
	}

	private static int solution(int[][] maps) {
		// 1. 이동할 수 있는 방향을 나타내는 배열 선언
		int[] rx = {-1, 0, 1, 0};
		int[] ry = {0, 1, 0, -1};

		// 2. 맵의 크기를 저장하는 변수 선언
		int N = maps.length;
		int M = maps[0].length;

		// 3. 최단 거리를 저장할 배열 생성
		int[][] dist = new int[N][M];

		// 4. bfs 탐색을 위한 큐 생성
		ArrayDeque<Node> queue = new ArrayDeque<>();

		// 5. 시작 정점에 대해서 큐 추가, 최단 거리 저장
		queue.addLast(new Node(0, 0));
		dist[0][0] = 1;

		// 6. queue가 빌 때까지 반복
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			// 7. 현재 위치에서 이동할 수 있는 모든 방향
			for (int i = 0; i < 4; i++) {
				int nr = now.r + rx[i];
				int nc = now.c + ry[i];

				// 8. 맵 밖으로 나가는 경우 예외 처리
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				// 9. 벽으로 가는 경우 예외 처리
				if (maps[nr][nc] == 0) {
					continue;
				}

				// 10. 이동한 위치가 처음 방문하는 경우, queue에 추가하고 거리 갱신
				if (dist[nr][nc] == 0) {
					queue.addLast(new Node(nr, nc));
					dist[nr][nc] = dist[now.r][now.c] + 1;
				}
			}
		}

		// 목적지까지 최단 거리 반환, 목적지에 도달하지 못한 경우에는 -1 반환
		return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
	}

	private static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
