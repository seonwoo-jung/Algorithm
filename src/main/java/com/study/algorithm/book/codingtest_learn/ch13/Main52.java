package com.study.algorithm.book.codingtest_learn.ch13;

import java.util.Arrays;

public class Main52 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
		System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
	}

	private static String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ?
			o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n)));
		return strings;
	}
}
