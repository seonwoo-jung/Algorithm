package com.study.algorithm.personal.study;

import java.util.*;

public class Main7 {

	public static void main(String[] args) {
		System.out.println(solution("[](){}"));
	}

	private static int solution(String s) {
		int len = s.length();
		int answer = 0;
		s += s;

		Map<Character, Character> map = new HashMap<>();
		map.put('[', ']');
		map.put('{', '}');
		map.put('(', ')');

		A: for (int i = 0; i < len; i++) {
			Stack<Character> stack = new Stack<>();
			for (int j = i; j < i + len; j++) {
				char x = s.charAt(j);
				if (map.containsKey(x)) {
					stack.push(map.get(x));
				} else {
					if (!stack.isEmpty() && stack.peek() == x) {
						stack.pop();
					} else {
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