package com.study.algorithm.site.programmers.level_2;

public class Main2 {

	public static void main(String[] args) {
		String solution = solution("-1 -2 -3 -4");
		System.out.println("solution = " + solution);
	}

	private static String solution(String s) {
		String[] x = s.split(" ");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (String val : x) {
			int num = Integer.valueOf(val);
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		return min + " " + max;
	}
}
