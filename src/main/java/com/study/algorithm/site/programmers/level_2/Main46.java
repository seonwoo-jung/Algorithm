package com.study.algorithm.site.programmers.level_2;

import java.util.PriorityQueue;
	import java.util.Queue;

public class Main46 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{10, 3, 7, 2}, 2));
		System.out.println(solution(new int[]{1, 2, 3, 4}, 3));
	}

	private static int solution(int[] ability, int number) {
		Queue<Integer> Q = new PriorityQueue<>();

		for (int i = 0; i < ability.length; i++) {
			Q.offer(ability[i]);
		}

		for (int i = 0; i < number; i++) {
			int sum = 0;

			for (int j = 0; j < 2; j++) {
				sum += Q.poll();
			}
			for (int j = 0; j < 2; j++) {
				Q.offer(sum);
			}

		}

		return Q.stream().mapToInt(Integer::intValue).sum();
	}
}