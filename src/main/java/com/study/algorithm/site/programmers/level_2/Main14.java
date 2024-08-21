package com.study.algorithm.site.programmers.level_2;

public class Main14 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 6, 8, 14}));
		System.out.println(solution(new int[]{1, 2, 3}));
	}

	private static int solution(int[] arr) {
		int answer = arr[0];

		for (int i = 1; i < arr.length; i++) {
			answer = LCM(answer, arr[i]);
		}

		return answer;
	}

	// 최대 공약수 구하기
	private static int GCD(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return GCD(b, a % b);
	}

	// 최소 공배수 구하기
	private static int LCM(int a, int b) {
		return a * b / GCD(a, b);
	}
}
