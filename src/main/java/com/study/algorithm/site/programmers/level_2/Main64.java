package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main64 {

	private static int n;
	private static int[] ch;
	private static List<List<Integer>> answer;

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(5)));
		System.out.println(Arrays.deepToString(solution(2)));
		System.out.println(Arrays.deepToString(solution(7)));
	}

	private static int[][] solution(int N) {
		answer = new ArrayList<>();
		n = N;
		ch = new int[N + 1];
		DFS(1, 0);
		return answer.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
	}

	private static void DFS(int s, int sum) {
		if (sum > 10) {
			return;
		}

		if (sum == 10) {
			List<Integer> list = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				if (ch[i] == 1) {
					list.add(i);
				}
			}
			answer.add(list);
		} else {
			for (int i = s; i <= n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					DFS(i + 1, sum + i);
					ch[i] = 0;
				}
			}
		}
	}
}
