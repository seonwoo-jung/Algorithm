package com.study.algorithm.site.programmers.level_0;

public class Main31 {
	public static void main(String[] args) {
		System.out.println(solution(1081));
	}

	private static int solution(int chicken) {
		int answer = chicken / 9;
		if (chicken > 1 && chicken % 9 == 0) {
			answer--;
		}
		return answer;
	}

	private static int solution2(int chicken) {
		int coupon = chicken;
		int count = 0;

		while (coupon >= 10) {
			int leftCoupon = coupon % 10;
			count += coupon / 10;
			coupon = leftCoupon + coupon / 10;
		}
		return count;
	}
}
