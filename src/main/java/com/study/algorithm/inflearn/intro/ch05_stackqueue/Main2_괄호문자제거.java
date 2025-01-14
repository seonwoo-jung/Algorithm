package com.study.algorithm.inflearn.intro.ch05_stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호문자제거
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 */
public class Main2_괄호문자제거 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		String solution = solution2(str);
		System.out.println("solution = " + solution);
	}

	private static String solution(String str) {
		Stack<Character> stack = new Stack<>();
		for (char x : str.toCharArray()) {
			if (x == ')') {
				while (stack.pop() != '(') {

				}
			} else {
				stack.push(x);
			}
		}
		return stack.toString().replaceAll("[, ]", "").replaceAll("[\\[\\]]", "");
	}

	private static String solution2(String str) {
		Stack<Character> stack = new Stack<>();
		List<Character> list = new ArrayList<>();

		for (char x : str.toCharArray()) {
			if (x == '(') {
				stack.push(x);
			} else if (x == ')') {
				stack.pop();
			} else if (stack.isEmpty()) {
				list.add(x);
			}
		}
		return list.toString();
	}
}