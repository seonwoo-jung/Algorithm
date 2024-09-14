package com.study.algorithm.site.programmers.level_1;

import java.util.ArrayList;
import java.util.List;

// 하노이의 탑
public class Main45 {

	private static List<int[]> ansList;

	public static void main(String[] args) {
		int[][] solution = solution(3);

		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution[i].length; j++) {
				System.out.printf("%d ", solution[i][j]);
			}
			System.out.println();
		}
	}

	private static int[][] solution(int n) {

		ansList = new ArrayList<>();
		DFS(n, 1, 3, 2);

		int[][] answer = new int[ansList.size()][];

		for (int i = 0; i < ansList.size(); i++) {
			answer[i] = ansList.get(i);
		}

		return answer;
	}

	private static void DFS(int n, int start, int to, int mid) {

		if (n == 1) {
			ansList.add(new int[]{start, to});
			return;
		}

		// 1번 기둥의 n-1개를 3번을 걸쳐 2번으로 이동시킴
		DFS(n - 1, start, mid, to);

		// 가장 큰 n을 1에서 3으로 이동시킴
		ansList.add(new int[]{start, to});

		// 2번의 기둥의 n-1개를 1번을 걸쳐 3번으로 이동시킴
		DFS(n - 1, mid, to, start);
	}
}