package com.study.algorithm.site.programmers.level_1;

/**
 * 프로그래머스 - 문자열 나누기
 */
public class Main56 {

	public static void main(String[] args) {
		System.out.println(solution("banana"));
		System.out.println(solution("abracadabra"));
		System.out.println(solution("aaabbaccccabba"));
	}

	public static int solution(String s) {
		int answer = 1;

		char x = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (count == 0) {
				answer++;
				x = s.charAt(i);
			}

			if (x == s.charAt(i)) {
				count++;
			} else {
				count--;
			}
		}
		return answer;
	}
}
