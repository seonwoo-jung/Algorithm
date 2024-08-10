package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 붕대 감기
 */
public class Main72 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));  // 5
		System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));  // -1
		System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));  // -1
		System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));  // 3
	}

	static int solution(int[] bandage, int health, int[][] attacks) {
		Map<Integer, Integer> attacksMap = new HashMap<>();

		Arrays.stream(attacks).forEach(x -> {
			attacksMap.put(x[0], x[1]);
		});

		int max = Arrays.stream(attacks).mapToInt(col -> col[0]).max().orElse(0);
		int maxHealth = health;
		int continuous = 0;

		for (int i = 1; i <= max; i++) {
			Integer isAttack = attacksMap.getOrDefault(i, 0);
			if (isAttack == 0) {
				continuous++;

				if (continuous >= bandage[0]) {
					continuous = continuous % bandage[0];
					health = health + bandage[1] + bandage[2]; // 추가회복
				} else {
					health += bandage[1];
				}

				if (health > maxHealth) {
					health = maxHealth;
				}

			} else {
				continuous = 0;
				health -= isAttack;
				if (health <= 0) {
					return -1;
				}
			}
		}
		return health;
	}
}
