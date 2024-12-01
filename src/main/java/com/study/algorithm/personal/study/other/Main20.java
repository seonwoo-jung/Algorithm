package com.study.algorithm.personal.study.other;

import java.util.LinkedList;
import java.util.Queue;

public class Main20 {

	public static void main(String[] args) {
		String solution = solution2(
			new String[]{"i", "water", "drink"},
			new String[]{"want", "to"},
			new String[]{"i", "want", "to", "drink", "water"}
		);
		System.out.println(solution);
	}

	private static String solution(String[] cards1, String[] cards2, String[] goal) {
		int p1 = 0, p2 = 0;
		for (String s : goal) {
			if (s.equals(cards1[p1])) {
				p1++;
			} else if (s.equals(cards2[p2])) {
				p2++;
			} else {
				return "NO";
			}
		}
		return "YES";
	}

	private static String solution2(String[] cards1, String[] cards2, String[] goal) {
		Queue<String> c1 = new LinkedList<>();
		Queue<String> c2 = new LinkedList<>();

		for (String s : cards1) {
			c1.offer(s);
		}

		for (String s : cards2) {
			c2.offer(s);
		}

		for (String s : goal) {
			if (c1.contains(s)) {
				c1.poll();
			} else if (c2.contains(s)) {
				c2.poll();
			} else {
				return "NO";
			}
		}

		return "YES";
	}
}