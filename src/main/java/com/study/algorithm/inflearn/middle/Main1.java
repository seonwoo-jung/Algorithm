package com.study.algorithm.inflearn.middle;

/**
 * 사다리 타기
 */
public class Main1 {
	public static void main(String[] args) {
		int n = 5;
		int[][] ladder = {{1, 3}, {2, 4}, {1, 4}};
		System.out.println(solution(n, ladder));
	}

	static int[] solution(int n, int[][] ladder) {
		int[] answer = {};
		int[][] graph = new int[n + 1][n + 1];

		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[i].length; j++) {
				if (ladder[i][j] != 0) {
					int point = ladder[i][j];
					graph[point][i + 1] = point + 1;
				}
			}
		}

		for (int i = 1; i < graph.length; i++) {
			for (int j = 1; j < graph[i].length; j++) {
				if (graph[i][j] != 0) {
					i = graph[i][j];
					j = j + 1;
				}
				System.out.printf("graph[%d][%d] = %d\n", i, j, graph[i][j]);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] != 0) {
					i = graph[i][j];
					j = j + 1;
				}
			}
			System.out.println("i = " + i);
		}

		return answer;
	}
}
