package com.study.algorithm.site.programmers.level_1;

public class Main43 {
	public static void main(String[] args) {
		int solution = solution("10203", "15");
		System.out.println("solution = " + solution);
	}

	private static int solution(String t, String p) {
		int len = p.length();
		long num = Long.parseLong(p);
		int result = 0;

		for (int i = 0; i < t.length() - len + 1; i++) {
			long diff = Long.parseLong(t.substring(i, i + len));
			if (diff <= num) result++;
		}
		return result;
	}
}