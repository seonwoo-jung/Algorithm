package com.study.algorithm.personal.study.other;

import java.util.LinkedList;
import java.util.Queue;

public class Main19 {

	public static void main(String[] args) {
		int solution = solution(5, 2);
		System.out.println(solution);
	}

	private static int solution(int n, int k) {
		Queue<Integer> Q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			Q.offer(i);
		}
		
		while (Q.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				Q.offer(Q.poll());
			}
			Q.poll();
		}

		return Q.poll();
	}
}