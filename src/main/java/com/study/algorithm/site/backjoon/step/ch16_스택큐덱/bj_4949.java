package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class bj_4949 {

	private static Map<Character, Character> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map.put('(', ')');
		map.put('[', ']');

		while (true) {

			String s = br.readLine();
			if (s.equals(".")) {
				break;
			}

			System.out.println(solution(s));
		}
	}

	private static String solution(String s) {
		Stack<Character> stack = new Stack<>();
		s = s.replaceAll("[^\\[\\]()]", "");

		for (char x : s.toCharArray()) {
			if (map.containsKey(x)) {
				stack.push(x);
			} else {
				if (stack.isEmpty()) {
					return "no";
				}
				char t = stack.pop();
				if (map.get(t) != x) {
					return "no";
				}
			}
		}
		return stack.isEmpty() ? "yes" : "no";
	}
}