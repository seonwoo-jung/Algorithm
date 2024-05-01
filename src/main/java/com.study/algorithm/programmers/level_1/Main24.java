package com.study.algorithm.programmers.level_1;

public class Main24 {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
		int solution = solution(numbers);
		System.out.println("solution = " + solution);
	}

	static int solution(int[] numbers) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			boolean flag = true;
			for (int j = 0; j < numbers.length; j++) {
				if (i == numbers[j]) {
					flag = false;
				}
			}
			if (flag) {
				sum += i;
			}
		}
		return sum;
	}
}
