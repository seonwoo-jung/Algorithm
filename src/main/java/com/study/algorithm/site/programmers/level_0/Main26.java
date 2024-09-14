package com.study.algorithm.site.programmers.level_0;

import java.util.Arrays;

public class Main26 {
	public static void main(String[] args) {
		int[] array = {3, 10, 28};
		solution(array);
	}

	private static int solution(int[] sides) {
		Arrays.sort(sides);
		return sides[2] < sides[0] + sides[1] ? 1 : 2;
	}
}
