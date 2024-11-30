package com.study.algorithm.personal.study;

public class Main36 {

	public static void main(String[] args) {
		solution(9);
	}

	private static void solution(int n) {
		int i = countNumbersWithSameOnes(n);
		System.out.println("i = " + i);
	}

	public static int countNumbersWithSameOnes(int n) {
		int k = Integer.bitCount(n); // n의 1의 개수
		String binary = Integer.toBinaryString(n); // n의 이진수 표현
		int length = binary.length(); // 이진수의 자릿수

		int count = 0;
		int currentOnes = 0;

		for (int i = 0; i < length; i++) {
			if (binary.charAt(i) == '1') {
				int remainingBits = length - i - 1;
				count += combinations(remainingBits, k - currentOnes - 1);
				currentOnes++;
			}
		}

		// 정확히 k개의 1이 있는 숫자만 포함 (현재 n의 1 개수는 이미 포함되지 않음)
		return count;
	}

	// 조합 계산 메서드
	public static int combinations(int n, int r) {
		if (r > n || r < 0) return 0;
		if (r == 0 || n == r) return 1;

		int result = 1;
		for (int i = 0; i < r; i++) {
			result *= (n - i);
			result /= (i + 1);
		}
		return result;
	}
}
