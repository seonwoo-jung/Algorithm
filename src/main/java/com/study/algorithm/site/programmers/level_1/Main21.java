package com.study.algorithm.site.programmers.level_1;

import java.util.Stack;

public class Main21 {

	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		int[] solution = solution(arr);
	}

	static int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (stack.size() == 0) {
				stack.push(arr[i]);
			} else if (stack.peek() != arr[i]) {
				stack.push(arr[i]);
			}
		}
		return stack.stream().mapToInt(Integer::intValue).toArray();
	}
}
