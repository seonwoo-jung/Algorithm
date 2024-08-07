package com.study.algorithm.site.programmers.level_1;

import java.util.Stack;

/**
 * 프로그래머스
 */
public class Main64 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
		System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
	}

	public static int solution(int[] ingredient) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int x : ingredient) {
			stack.push(x);

			if (stack.size() >= 4) {
				int size = stack.size();
				if (stack.get(size - 4) == 1 && stack.get(size - 3) == 2 &&
					stack.get(size - 2) == 3 && stack.get(size - 1) == 1) {
					answer++;
					stack.pop(); // 1
					stack.pop(); // 3
					stack.pop(); // 2
					stack.pop(); // 1
				}
			}
		}

		return answer;
	}
}
