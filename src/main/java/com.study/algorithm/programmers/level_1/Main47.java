package com.study.algorithm.programmers.level_1;

public class Main47 {

	public static void main(String[] args) {
		System.out.println(solution("AB", 1));
		System.out.println(solution("z", 1));
		System.out.println(solution("a B z", 4));
	}

	static String solution(String s, int n) {
		String answer = "";
		char[] x = s.toCharArray();
		for (int i = 0; i < x.length; i++) {
			if (x[i] == ' ') {
				answer += x[i];
				continue;
			}
			if (x[i] >= 'a' && x[i] <= 'z') {
				if (x[i] + n > 'z') {
					answer += (char) (x[i] - 26 + n);
				} else {
					answer += (char) (x[i] + n);
				}
			} else if (x[i] >= 'A' && x[i] <= 'Z') {
				if (x[i] + n > 'Z') {
					answer += (char) (x[i] - 26 + n);
				} else {
					answer += (char) (x[i] + n);
				}
			}
		}
		return answer;
	}
}