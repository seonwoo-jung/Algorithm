package com.study.algorithm.programmers.level_0;

import java.util.Arrays;

public class Main65 {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5};
		int num1 = 1;
		int num2 = 3;
		int[] solution = solution(numbers, num1, num2);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int[] numbers, int num1, int num2) {
		return Arrays.copyOfRange(numbers, num1, num2 + 1);
	}
}