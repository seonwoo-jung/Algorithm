package com.study.algorithm.site.programmers.level_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main40 {

	public static void main(String[] args) {
		System.out.println(solution("[](){}"));
		System.out.println(solution("}]()[{"));
		System.out.println(solution("[)(]"));
		System.out.println(solution("}}}"));
	}

	private static int solution(String s) {
		int answer = 0;
		s += s;
		Map<Character, Character> pairMap = new HashMap<>();
		pairMap.put(']', '[');
		pairMap.put('}', '{');
		pairMap.put(')', '(');
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length() / 2; i++) {
			stack.push(s.charAt(i));
			for (int j = i + 1; j < s.length() / 2 + i; j++) {
				char x = s.charAt(j);
				if (!stack.isEmpty() && stack.peek() == pairMap.get(x)) {
					stack.pop();
				} else {
					stack.push(s.charAt(j));
				}
			}
			if (stack.size() == 0) {
				answer++;
			} else {
				stack.clear();
			}
		}

		return answer;
	}
}