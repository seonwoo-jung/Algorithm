package com.study.algorithm.site.programmers.level_2;

public class Main49 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
		System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
		System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
		System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
	}

	private static int solution(int[] bandage, int health, int[][] attacks) {
		int len = attacks[attacks.length - 1][0];
		int myHealth = health;
		int time = 0;
		int idx = 0;
		for (int i = 1; i <= len; i++) {
			if (attacks[idx][0] == i) {
				myHealth -= attacks[idx++][1];
				time = 0;
				if (myHealth <= 0) {
					return -1;
				}
			} else {
				time++;
				myHealth += bandage[1];
				if (time == bandage[0]) {
					myHealth += bandage[2];
					time = 0;
				}
				if (myHealth > health) {
					myHealth = health;
				}
			}
		}
		return myHealth;
	}
}
