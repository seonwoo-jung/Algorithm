package com.study.algorithm.site.programmers.level_0;

public class Main93 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 4, 5, 2, 1}));
		System.out.println(solution(new int[] {5, 7, 8, 3}));
	}

	private static int solution(int[] numList) {
		String evenSum = "";
		String oddSum = "";
		for (int i = 0; i < numList.length; i++) {
			if (numList[i] % 2 == 0) {
				evenSum += numList[i];
			} else {
				oddSum += numList[i];
			}
		}
		return Integer.parseInt(evenSum) + Integer.parseInt(oddSum);
	}
}