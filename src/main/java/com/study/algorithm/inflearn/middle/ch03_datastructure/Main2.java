package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.Stack;

// 문자열 압축해제
public class Main2 {

	public static void main(String[] args) {
		System.out.println(solution("3(a2(b))ef"));
		System.out.println(solution("2(ab)k3(bc)"));
		System.out.println(solution("2(ab3((cd)))"));
		System.out.println(solution("2(2(ab)3(2(ac)))"));
		System.out.println(solution("3(ab2(sg))"));
	}

	private static String solution(String s) {
		String answer = "";
		Stack<String> stack = new Stack<>();

		for (Character x : s.toCharArray()) {
			if (x == ')') {
				String tmp = "";
				while (!stack.empty()) {
					String c = stack.pop();
					if (c.equals("(")) {
						String num = "";
						while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
							num = stack.pop() + num;
						}
						String res = "";
						int cnt = 0;
						if (num.equals("")) {
							cnt = 1;
						} else {
							cnt = Integer.parseInt(num);
						}
						for (int i = 0; i < cnt; i++) {
							res += tmp;
						}
						stack.push(res);
						break;
					}
					tmp = c + tmp;
				}
			} else {
				stack.push(String.valueOf(x));
			}
		}

		for (String x : stack) answer += x;

		return answer;
	}
}
