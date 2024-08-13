package com.study.algorithm.site.programmers.level_2;

public class Main9 {

	private static int[] student;
	private static int answer = Integer.MIN_VALUE;


	public static void main(String[] args) {
		int solution = solution(new int[][]{{20, 30}, {30, 20}, {20, 30}});
		System.out.println("solution = " + solution);
	}

	public static int solution(int[][] ability) {
		student = new int[ability.length];

		dfs(0, 0, ability);

		return answer;
	}

	private static void dfs(int sport, int sum, int[][] ability) {
		if (sport == ability[0].length) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i < student.length; i++) {
			if (student[i] == 0) {
				student[i] = 1;
				dfs(sport + 1, sum + ability[i][sport], ability);
				student[i] = 0;
			}
		}
	}
}
