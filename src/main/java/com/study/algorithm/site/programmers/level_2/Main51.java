package com.study.algorithm.site.programmers.level_2;

public class Main51 {

	private static final int MAX = 999999;

	private static int[][] map;
	private static boolean redEnd, blueEnd;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static boolean[][][] visited;

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1, 4}, {0, 0}, {2, 3}}));
		System.out.println(solution(new int[][]{{1, 0, 2}, {0, 0, 0}, {5, 0, 5}, {4, 0, 3}}));
	}

	private static int solution(int[][] maze) {
		Point cntRed = null;
		Point cntBlue = null;

		map = new int[maze.length][maze[0].length];
		visited = new boolean[maze.length][maze[0].length][2];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				map[i][j] = maze[i][j];
				// 각 수레의 시작위치 초기화
				if (maze[i][j] == 1) {
					cntRed = new Point(i, j);
				} else if (maze[i][j] == 2) {
					cntBlue = new Point(i, j);
				}
			}
		}
		// 시작 위치 방문 처리 (0은 빨간 수레, 1은 파란 수레)
		visited[cntRed.x][cntRed.y][0] = true;
		visited[cntBlue.x][cntBlue.y][1] = true;
		int answer = backtracking(cntRed, cntBlue, 0);
		return (answer == MAX) ? 0 : answer;
	}

	// 백트래킹
	private static int backtracking(Point red, Point blue, int result) {
		// 두 수레가 모두 도착 시 result 반환
		if (redEnd && blueEnd) {
			return result;
		}
		int answer = MAX;

		// 2중 for문으로 16가지 경우의 수
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// 도착지점에 도착한 경우엔 움직이지 않음
				Point nRed = (!redEnd) ? getNext(red.x, red.y, i) : red;
				Point nBlue = (!blueEnd) ? getNext(blue.x, blue.y, j) : blue;

				// 이동 불가능한 경우 conitnue
				if (!isPossible(red, nRed, blue, nBlue)) {
					continue;
				}

				// 방문 기록 저장
				visited[nRed.x][nRed.y][0] = true;
				visited[nBlue.x][nBlue.y][1] = true;

				if (map[nRed.x][nRed.y] == 3) {
					redEnd = true;
				}

				if (map[nBlue.x][nBlue.y] == 4) {
					blueEnd = true;
				}

				// 가장 적게 걸리는 턴 수
				answer = Math.min(answer, backtracking(nRed, nBlue, result + 1));

				// 방문 기록 및 도착 기록 초기화
				redEnd = false;
				blueEnd = false;
				visited[nRed.x][nRed.y][0] = false;
				visited[nBlue.x][nBlue.y][1] = false;
			}
		}
		return answer;
	}

	// 해당 방향으로 움직임 반환
	private static Point getNext(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		return new Point(nx, ny);
	}

	// 해당 방향으로 움직이는 것이 가능한지 판단
	// (현재 빨간 수레 , 다음 빨간 수레, 현재 파란 수레, 다음 파란 수레)
	private static boolean isPossible(Point cntRed, Point red, Point cntBlue, Point blue) {
		// 기본 탐색 규칙
		if (red.x < 0 || red.y < 0 || red.x >= map.length || red.y >= map[0].length ||
			blue.x < 0 || blue.y < 0 || blue.x >= map.length || blue.y >= map[0].length ||
			map[red.x][red.y] == 5 ||
			map[blue.x][blue.y] == 5) {
			return false;
		}

		// 두 수레 스위치 체크
		if ((cntRed.x == blue.x && cntRed.y == blue.y)
			&& (cntBlue.x == red.x && cntBlue.y == red.y)) {
			return false;
		}

		// 도착지점에 도착하지도 않고 중복방문이라면 false
		if ((!redEnd && visited[red.x][red.y][0])
			|| (!blueEnd && visited[blue.x][blue.y][1])) {
			return false;
		}

		// 두 수레가 동일한 지점에 위치시
		if (red.x == blue.x && red.y == blue.y) {
			return false;
		}
		return true;
	}

	private static class Point {

		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
