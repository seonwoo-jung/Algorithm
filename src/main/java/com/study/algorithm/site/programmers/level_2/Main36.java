package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main36 {

	public static void main(String[] args) {
		System.out.println(solution(437674, 3));
		System.out.println(solution(110011, 10));
	}

	private static int solution(int n, int k) {
		String s = Integer.toString(n, k);

		// 정규표현식: 0n0, n0, 0n, n에 해당하는 패턴
		String regex = "0*([1-9]+)0*";

		// Pattern 객체 생성
		Pattern pattern = Pattern.compile(regex);

		// Matcher 객체 생성
		Matcher matcher = pattern.matcher(s);

		List<String> list = new ArrayList<>();
		// 패턴이 일치하는 부분을 찾고 출력
		while (matcher.find()) {
			System.out.println("group0 = " + matcher.group(0));
			System.out.println("group1 = " + matcher.group(1));
			String group = matcher.group(1);
			list.add(group);
		}

		return (int) list.stream()
			.filter(x -> isPrime(Double.parseDouble(x)))
			.count();
	}

	private static boolean isPrime(double number) {
		if (number < 2) return false;
		return IntStream.rangeClosed(2, (int) Math.sqrt(number))
			.allMatch(n -> number % n != 0);
	}
}