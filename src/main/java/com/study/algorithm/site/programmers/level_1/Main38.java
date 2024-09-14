package com.study.algorithm.site.programmers.level_1;

public class Main38 {
	public static void main(String[] args) {
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		String solution = solution(cards1, cards2, goal);
		System.out.println("solution = " + solution);
	}

	private static String solution(String[] cards1, String[] cards2, String[] goal) {
		int idx1 = 0, idx2 = 0;
		for (int i = 0; i < goal.length; i++) {
			if (idx1 < cards1.length && goal[i].equals(cards1[idx1])) {
				idx1++;
			} else if (idx2 < cards2.length && goal[i].equals(cards2[idx2])) {
				idx2++;
			} else {
				return "No";
			}
		}
		return "Yes";
	}
}


