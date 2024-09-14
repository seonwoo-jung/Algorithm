package com.study.algorithm.book.codingtest_learn.ch06;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 괄호 회전하기
 */
public class Main10 {

	public static void main(String[] args) {
		int answer1 = solution("[](){}");
		int answer2 = solution("}]()[{");
		int answer3 = solution("[)(]");
		int answer4 = solution("}}}");

		System.out.println("answer = " + answer1);
		System.out.println("answer = " + answer2);
		System.out.println("answer = " + answer3);
		System.out.println("answer = " + answer4);
	}

	private static int solution(String s) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		int n = s.length();
		s += s;
		int answer = 0;

		A:
		for (int i = 0; i < n; i++) {
			ArrayDeque<Character> stack = new ArrayDeque<>();

			for (int j = i; j < i + n; j++) {
				char c = s.charAt(j);

				if (!map.containsKey(c)) {
					stack.push(c);
				} else {
					if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
						continue A;
					}
				}
			}
			if (stack.isEmpty()) {
				answer++;
			}
		}
		return answer;
	}
}
