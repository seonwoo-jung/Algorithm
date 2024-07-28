package com.study.algorithm.site.programmers.level_1;

public class Main29 {

	public static void main(String[] args) {
		long solution = solution(3, 20, 4);
		System.out.println(solution);
	}

	static long solution(int price, int money, int count) {
		long answer = 0;
		long sum = 0;

		for (int i = 1; i <= count; i++) {
			sum += (price * i);
		}
		if (sum > money) answer = sum - money;
		return answer;
	}
}