package com.study.algorithm.book.codingtest_learn.ch13_정렬;

import java.util.ArrayList;

public class Main55 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{6, 10, 2}));
	}

	private static String solution(int[] numbers) {
		ArrayList<String> list = new ArrayList<>();
		for (int number : numbers) {
			list.add(String.valueOf(number));
		}

		list.sort((o1, o2) -> {
			int a = Integer.parseInt(o1 + o2);
			int b = Integer.parseInt(o2 + o1);
			return Integer.compare(b, a);
		});

		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}

		return sb.charAt(0) == '0' ? "0" : sb.toString();
	}
}
