package com.study.algorithm.book.codingtest_learn.ch07_큐;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 카드 뭉치
 */
public class Main17_카드뭉치 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
		System.out.println(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
	}

	private static String solution(String[] cards1, String[] cards2, String[] goal) {
		ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
		ArrayDeque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
		ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

		while (!goalDeque.isEmpty()) {
			if (!queue1.isEmpty() && queue1.peek().equals(goalDeque.peek())) {
				queue1.pollFirst();
				goalDeque.pollFirst();
			} else if (!queue2.isEmpty() && queue2.peek().equals(goalDeque.peek())) {
				queue2.pollFirst();
				goalDeque.pollFirst();
			} else {
				break;
			}
		}

		return goalDeque.isEmpty() ? "Yes" : "No";
	}
}
