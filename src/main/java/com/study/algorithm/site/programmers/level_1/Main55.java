package com.study.algorithm.site.programmers.level_1;

/**
 * 프로그래머스 - 옹알이(2)
 */
public class Main55 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"aya", "yee", "u", "maa"}));
		System.out.println(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
	}

	public static int solution(String[] babbling) {
		int answer = 0;
		String[] str = {"aya", "ye", "woo", "ma"};
		String[] repeatStr = {"ayaaya", "yeye", "woowoo", "mama"};

		for (int i = 0; i < babbling.length; i++) {
			for (int j = 0; j < str.length; j++) {
				babbling[i] = babbling[i].replaceAll(repeatStr[j], "1").replaceAll(str[j], " ");
			}

			if (babbling[i].trim().length() == 0) {
				answer++;
			}
		}
		return answer;
	}
}
