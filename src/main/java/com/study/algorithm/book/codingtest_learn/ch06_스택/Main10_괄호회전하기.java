package com.study.algorithm.book.codingtest_learn.ch06_스택;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 괄호 회전하기
 */
public class Main10_괄호회전하기 {

	public static void main(String[] args) {
		System.out.println(solution("[](){}"));
		System.out.println(solution("}]()[{"));
		System.out.println(solution("[)(]"));
		System.out.println(solution("}}}"));
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
