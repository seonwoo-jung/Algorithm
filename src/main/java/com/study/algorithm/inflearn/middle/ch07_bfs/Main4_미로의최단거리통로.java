package com.study.algorithm.inflearn.middle.ch07_bfs;

public class Main4_미로의최단거리통로 {

	public static void main(String[] args) {
		int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 1, 0, 0, 0},
			{1, 1, 0, 1, 0, 1, 1},
			{1, 1, 0, 1, 0, 0, 0},
			{1, 0, 0, 0, 1, 0, 0},
			{1, 0, 1, 0, 0, 0, 0}};
		System.out.println(solution(arr));
	}

	private static int solution(int[][] board) {
		int answer = 0;

		return answer;
	}
}
