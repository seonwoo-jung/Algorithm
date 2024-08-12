package com.study.algorithm.site.programmers.level_2;

public class Main5 {

	public static void main(String[] args) {
		String solution = solution("3people unFollowed me");
		System.out.println("solution = " + solution);
	}

	private static String solution(String s) {
		boolean isUpper = true;

		StringBuilder sb = new StringBuilder();

		for (char x : s.toCharArray()) {
			if (Character.isAlphabetic(x)) {
				if (isUpper) {
					sb.append(Character.toUpperCase(x));
					isUpper = false;
				} else {
					sb.append(Character.toLowerCase(x));
				}
			} else {
				if (x == ' ') {
					sb.append(" ");
					isUpper = true;
				} else {
					sb.append(x);
					isUpper = false;
				}
			}
		}

		return sb.toString();
	}
}
