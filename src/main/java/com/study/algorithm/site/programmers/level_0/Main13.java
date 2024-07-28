package com.study.algorithm.site.programmers.level_0;

import java.util.Arrays;

public class Main13 {

	public static void main(String[] args) {
		solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12});
	}

	static int[] solution(int n, int[] numlist) {
		return Arrays.stream(numlist).filter(value -> value % n == 0).toArray();
	}
}