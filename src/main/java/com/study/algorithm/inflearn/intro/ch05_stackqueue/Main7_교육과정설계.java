package com.study.algorithm.inflearn.intro.ch05_stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 교육과정설계
 */
public class Main7_교육과정설계 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String a = kb.next();
		String b = kb.next();
		System.out.println("solution = " + solution(a, b));
	}

	private static String solution(String need, String plan) {
		String answer = "YES";
		Queue<Character> Q = new LinkedList<>();

		for (char x : need.toCharArray()) {
			Q.offer(x);
		}

		for (char x : plan.toCharArray()) {
			if (Q.contains(x)) {
				if (x != Q.poll()) return "NO";
			}
		}
		if (!Q.isEmpty()) return "NO";
		return answer;
	}
}