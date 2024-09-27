package com.study.algorithm.site.programmers.level_0;

public class Main1 {

	public static void main(String[] args) {
		int result = solution(new String[]{"aya", "yee", "u", "maa", "wyeoo", "ayayewoo"});
		System.out.println("result = " + result);
	}

	private static int solution(String[] babbling) {
		int answer = 0;

		for (int i = 0; i < babbling.length; i++) {

			/**
			 * contains()의 경우 인자로 전달된 문자열이 존재하는지 여부를 return
			 * matches()의 경우 정규표현식을 인자로 받고 동일한 패턴의 문자열이면 true를 return
			 */
			if (babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")) {
				answer++;
			}
		}
		return answer;
	}
}
