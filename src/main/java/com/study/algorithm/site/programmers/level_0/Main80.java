package com.study.algorithm.site.programmers.level_0;

public class Main80 {
	public static void main(String[] args) {
		int solution = solution(580_000);
		System.out.println("solution = " + solution);
	}

	static int solution(int price) {
		if (price >= 500_000) {
			price *= 0.8;
		} else if (price >= 300_000) {
			price *= 0.9;
		} else if (price >= 100_000) {
			price *= 0.95;
		}
		return price;
	}
}