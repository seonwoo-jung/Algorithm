package com.study.algorithm.book.codingtest_learn.ch07;

import java.util.ArrayDeque;

/**
 * 요세푸스 문제
 */
public class Main15 {

	public static void main(String[] args) {
		System.out.println(solution(5, 2));
		System.out.println(solution(10, 2));
	}

	private static int solution(int N, int K) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}

		while (deque.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				deque.addLast(deque.pollFirst());
			}
			deque.pollFirst();
		}

		return deque.pollFirst();
	}
}
