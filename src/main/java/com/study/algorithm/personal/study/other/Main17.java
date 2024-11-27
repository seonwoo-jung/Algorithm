package com.study.algorithm.personal.study.other;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Main17 {

	public static void main(String[] args) {
		int[] solution = solution2(new int[]{1, 1, 3, 3, 0, 1, 1});
		System.out.println(Arrays.toString(solution));
	}

	private static int[] solution(int[] arr) {
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

	private static int[] solution2(int[] arr) {
		Set<Integer> set = new LinkedHashSet<>();
		for (int i : arr) {
			set.add(i);
		}
		return set.stream().mapToInt(Integer::intValue).toArray();
	}
}