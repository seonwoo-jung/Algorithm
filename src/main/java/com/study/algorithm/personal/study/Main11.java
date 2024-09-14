package com.study.algorithm.personal.study;

public class Main11 {

	public static void main(String[] args) {
		int solution = solution(new int[]{2, 4, 1, 5, 3, 3}, new int[]{2, 3, 4, 5, 5, 3});
		System.out.println("solution = " + solution);
	}

	private static int solution(int[] marks, int[] answers) {
		int maxCorrectCount = 0;
		int bestN = 0;

		// 모든 가능한 n값에 대해 확인 (0부터 답안지 길이까지)
		for (int n = 0; n <= marks.length; n++) {
			int correctCount = getCorrectCount(marks, answers, n);
			if (correctCount > maxCorrectCount) {
				maxCorrectCount = correctCount;
				bestN = n;
			}
		}

		System.out.println("가장 많은 정답을 맞춘 n값: " + bestN);
		System.out.println("맞춘 정답 개수: " + maxCorrectCount);
		return maxCorrectCount;
	}

	private static int getCorrectCount(int[] submitted, int[] correct, int shift) {
		int count = 0;
		int len = submitted.length;

		for (int i = 0; i < len; i++) {
			// correct 배열에서의 인덱스를 계산할 때 밀린 값을 적용
			int shiftedIndex = (i + shift) % len;
			// 밀린 인덱스가 길이 범위 내에 있는 경우에만 비교
			if (shiftedIndex < correct.length && submitted[i] == correct[shiftedIndex]) {
				count++;
			}
		}

		return count;
	}
}