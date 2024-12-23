package com.study.algorithm.inflearn.middle.ch06_dfs;

public class Main3_바둑대회 {

	private static int[] ch;
	private static int n, answer;

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
		System.out.println(solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
		System.out.println(solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
	}

	private static int solution(int[][] cans) {
		answer = Integer.MAX_VALUE;
		n = cans.length;
		ch = new int[cans.length];
		DFS(0, 0, cans);
		return answer;
	}

	private static void DFS(int L, int s, int[][] cans) {
		if (L == n / 2) {
			int aSum = 0, bSum = 0;
			for (int i = 0; i < n; i++) {
				if (ch[i] == 1) {
					aSum += cans[i][0];
				} else {
					bSum += cans[i][1];
				}
			}
			answer = Math.min(answer, Math.abs(aSum - bSum));
		} else {
			for (int i = s; i < n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					DFS(L + 1, i + 1, cans);
					ch[i] = 0;
				}
			}
		}
	}
}
