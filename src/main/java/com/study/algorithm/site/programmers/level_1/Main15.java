package com.study.algorithm.site.programmers.level_1;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 두 정수 사이의 합
 */
public class Main15 {

	public static void main(String[] args) {
		System.out.println(solution(3, 3));
	}

	static long solution(int a, int b) {
		return sumAtoB(min(a, b), max(a, b));
	}

	static long sumAtoB(int a, int b) {
		return (b - a + 1) * (a + b) / 2;
	}
}
