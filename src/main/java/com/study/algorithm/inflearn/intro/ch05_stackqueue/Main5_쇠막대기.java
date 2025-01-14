package com.study.algorithm.inflearn.intro.ch05_stackqueue;

import static java.lang.System.in;

import java.util.Scanner;
import java.util.Stack;

/**
 * 쇠막대기
 */
public class Main5_쇠막대기 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println("solution = " + solution(str));
	}

	private static int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for (char x : str.toCharArray()) {
			if (x == ')' && stack.peek() == '(') {
				stack.pop();
				answer += stack.size();
			} else {
				stack.push(x);
			}
		}

		return answer;
	}
}