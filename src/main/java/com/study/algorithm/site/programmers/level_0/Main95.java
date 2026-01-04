package com.study.algorithm.site.programmers.level_0;

public class Main95 {
	public static void main(String[] args) {
		System.out.println(solution(2, 91));
		System.out.println(solution(91, 2));
	}

    private static int solution(int a, int b) {
		int result1 = Integer.parseInt(a + String.valueOf(b));
		int result2 = 2 * a * b;
		return Math.max(result1, result2);
    }
}