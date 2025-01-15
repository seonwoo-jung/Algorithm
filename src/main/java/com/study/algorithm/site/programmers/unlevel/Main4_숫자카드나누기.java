package com.study.algorithm.site.programmers.unlevel;

public class Main4_숫자카드나누기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{10, 7}, new int[]{5, 20}));
		System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
		System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
	}

	private static int solution(int[] arrayA, int[] arrayB) {
		// 0. 입력 및 초기화
		int answer = 0;
		int gcdA = arrayA[0];
		int gcdB = arrayB[0];

		// 1. 각 배열의 최대공약수 구하기
		for (int i = 1; i < arrayA.length; i++) {
			gcdA = GCD(gcdA, arrayA[i]);
			gcdB = GCD(gcdB, arrayB[i]);
		}

		// 2. 서로의 배열을 나눌 수 없는지 확인
		if (notDivisible(arrayB, gcdA)) {
			if (answer < gcdA) {
				answer = gcdA;
			}
		}

		if (notDivisible(arrayA, gcdB)) {
			if (answer < gcdB) {
				answer = gcdB;
			}
		}

		// 3. 최댓값 반환
		return answer;
	}

	private static boolean notDivisible(int[] arr, int num) {
		for (int n : arr) {
			if (n % num == 0) {
				return false;
			}
		}
		return true;
	}

	private static int GCD(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return GCD(b, a % b);
	}
}
