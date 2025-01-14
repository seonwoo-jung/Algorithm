package com.study.algorithm.inflearn.intro.ch05_stackqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 올바른 괄호 (Stack)
 */
public class Main1_올바른괄호 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		String solution = solution(str);
		System.out.println("solution = " + solution);
	}

	private static String solution(String str) {
		Stack<Character> stack = new Stack<>();
		for (char x : str.toCharArray()) {
			if (x == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty()) return "NO";
				stack.pop();
			}
		}

		return stack.isEmpty() ? "YES" : "NO";
	}
}
