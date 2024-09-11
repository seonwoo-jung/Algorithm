package com.study.algorithm.personal.study;

public class Main8 {

	private static int[] N;
	private static boolean[] ch;
	private static String answer = "0";

	public static void main(String[] args) {
		String solution = solution(new int[]{6, 10, 2});
		System.out.println("solution = " + solution);
	}

	private static String solution(int[] n) {
		ch = new boolean[n.length];
		N = n;
		DFS(0, "0");

		return answer;
	}

	private static void DFS(int L, String sum) {
		if (N.length == L) {
			answer = String.valueOf(Math.max(Integer.parseInt(answer), Integer.parseInt(sum)));
		}
		for (int i = 0; i < N.length; i++) {
			if (!ch[i]) {
				ch[i] = true;
				DFS(L + 1, sum + N[i]);
				ch[i] = false;
			}
		}
	}
}
