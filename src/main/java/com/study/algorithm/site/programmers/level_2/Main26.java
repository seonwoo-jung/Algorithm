package com.study.algorithm.site.programmers.level_2;

public class Main26 {

	private static boolean[] visited;

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
	}

	private static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n]; // 방문 여부 저장

		// 방문하지 않은 컴퓨터인 경우 dfs 탐색 후 네트워크의 개수를 증가시킴
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				DFS(i, computers, visited);
				answer++;
			}
		}
		return answer;
	}

	private static void DFS(int node, int[][] computers, boolean[] visited) {
		visited[node] = true;

		for (int i = 0; i < computers[node].length; i++) {
			if (computers[node][i] == 1 && !visited[i]) {
				DFS(i, computers, visited); // 재귀적으로 dfs 탐색
			}
		}
	}
}
