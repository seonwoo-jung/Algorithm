package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;
import java.util.Stack;

public class Main69 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
		System.out.println(Arrays.toString(solution(new int[]{9, 1, 5, 3, 6, 2})));
	}

	private static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for (int i = 1; i < numbers.length; i++) {
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				Integer idx = stack.pop();
				answer[idx] = numbers[i];
			}
			stack.push(i);
		}

		return answer;
	}
}