package com.study.algorithm.site.programmers.level_0;

import java.util.stream.IntStream;

public class Main28 {
	public static void main(String[] args) {
		System.out.println(solution(1, 13, 1));
	}

	private static int solution(int i, int j, int k) {

		return (int) IntStream.rangeClosed(i, j)
				.mapToObj(Integer::toString)
				.flatMapToInt(String::chars)
				.filter(c -> c == Integer.toString(k).charAt(0))
				.count();
	}
}
