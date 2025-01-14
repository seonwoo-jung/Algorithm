package com.study.algorithm.inflearn.intro.ch05_stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 공주구하기
 */
public class Main6_공주구하기 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		System.out.println("solution = " + solution(n, k));
	}

	private static int solution(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (queue.size() != 1) {
			for (int i = 1; i <= k; i++) {
				if (i == k) {
					queue.poll();
					continue;
				}
				Integer temp = queue.poll();
				queue.offer(temp);
			}
		}

		return queue.element().intValue();
	}
}