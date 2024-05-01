package com.study.algorithm.programmers.level_0;

public class Main23 {
	public static void main(String[] args) {
		System.out.println(solution("dfjardstddetckdaccccdegk", 4));
	}

	static String solution(String cipher, int code) {
		String buffer = "";
		int index = 0;
		for (int i = 0; i < cipher.length() / code; i++) {
			if (i == 0) {
				index = code - 1;
				buffer += cipher.charAt(index);
			} else {
				index += code;
				buffer += cipher.charAt(index);
			}
		}
		return buffer;
	}

	static String solution2(String cipher, int code) {
		String answer = "";

		for (int i = code; i <= cipher.length(); i += code) {
			answer += cipher.substring(i - 1, i);
		}

		return answer;
	}
}
