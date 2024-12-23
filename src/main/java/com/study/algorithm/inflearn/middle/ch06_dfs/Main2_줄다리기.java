package com.study.algorithm.inflearn.middle.ch06_dfs;

public class Main2_줄다리기 {

	private static int answer;
	private static int[] nums, ch;
	private static int[][] relation;

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
		System.out.println(solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
		System.out.println(solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
		System.out.println(solution(new int[][]{{1, 7}}));
		System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
	}

	private static int solution(int[][] fight) {
		answer = 0;
		nums = new int[7];
		ch = new int[7];
		relation = new int[8][8];
		for (int i = 0; i < 7; i++) {
			nums[i] = i + 1;
		}
		for (int[] x : fight) {
			relation[x[0]][x[1]] = 1;
			relation[x[1]][x[0]] = 1;
		}
		DFS(0, 0);
		return answer;
	}

	private static void DFS(int L, int number) {
		if (L == nums.length) {
			answer++;
		} else {
			for (int i = 0; i < 7; i++) {
				if (ch[i] == 0) {
					if (relation[nums[i]][number % 10] == 1) {
						continue;
					}
					ch[i] = 1;
					DFS(L + 1, number * 10 + nums[i]);
					ch[i] = 0;
				}
			}
		}
	}
}
