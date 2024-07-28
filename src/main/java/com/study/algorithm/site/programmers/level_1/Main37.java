package com.study.algorithm.site.programmers.level_1;

public class Main37 {
	public static void main(String[] args) {
		int solution = solution("2three45sixseven");
		System.out.println("solution = " + solution);
	}

	static int solution(String s) {
		String[] dir = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

		for (int i = 0; i < dir.length; i++) {
			s = s.replaceAll(dir[i], i + "");
		}

		return Integer.parseInt(s);
	}
}


