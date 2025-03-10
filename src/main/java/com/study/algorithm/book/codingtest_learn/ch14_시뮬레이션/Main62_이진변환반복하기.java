package com.study.algorithm.book.codingtest_learn.ch14_시뮬레이션;

import java.util.Arrays;

public class Main62_이진변환반복하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("110010101001")));
		System.out.println(Arrays.toString(solution("01110")));
		System.out.println(Arrays.toString(solution("1111111")));
	}

	private static int[] solution(String s) {

		int answer = 0;
		int round = 0;
		while (!s.equals("1")) {
			int originalSize = s.length();
			s = s.replaceAll("0", "");
			int removedSize = s.length();
			int diff = originalSize - removedSize;
			answer += diff;
			s = Integer.toBinaryString(s.length());
			round++;
		}

		return new int[]{round, answer};
	}
}
