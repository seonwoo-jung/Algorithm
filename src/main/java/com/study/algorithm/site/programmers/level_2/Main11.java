package com.study.algorithm.site.programmers.level_2;

import java.util.Stack;

public class Main11 {

	public static void main(String[] args) {
		int solution1 = solution("baabaa");
		int solution2 = solution("cdcd");
		System.out.println("solution1 = " + solution1);
		System.out.println("solution2 = " + solution2);
	}

	private static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		// 문자열 순회
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) { // 스택이 비어있다면 현재 문자를 스택에 추가
				stack.push(s.charAt(i));
			} else {
				char ch = s.charAt(i); // 현재 문자

				// 스택의 맨 위 문자와 현재 문자가 같다면 스택에서 제거
				if (stack.peek() == ch) {
					stack.pop();
					// 같지 않다면 현재 문자를 스택에 추가
				} else {
					stack.push(ch);
				}
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
}
