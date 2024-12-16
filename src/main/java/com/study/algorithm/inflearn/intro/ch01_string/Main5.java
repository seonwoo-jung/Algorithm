package com.study.algorithm.inflearn.intro.ch01_string;

/**
 * 특정 문자 뒤집기
 */
public class Main5 {
	public static void main(String[] args) {
		System.out.println(solution("a#b!GE*T@S"));
	}

	private static String solution(String str) {
		String answer;
		char[] s = str.toCharArray();
		int lt = 0, rt = str.length() - 1;
		while (lt < rt) {

			if (!Character.isAlphabetic(s[lt])) {
				lt++;
			} else if (!Character.isAlphabetic(s[rt])) {
				rt--;
			} else {
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp;
				lt++;
				rt--;
			}
		}
		answer = String.valueOf(s);

		return answer;
	}
}