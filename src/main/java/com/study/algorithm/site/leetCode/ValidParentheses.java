package com.study.algorithm.site.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([])"));
	}

	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		for (char x : s.toCharArray()) {
			if (map.containsKey(x)) {
				if (!stack.isEmpty() && stack.peek() == map.get(x)) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				stack.push(x);
			}
		}

		return stack.isEmpty();
	}
}
