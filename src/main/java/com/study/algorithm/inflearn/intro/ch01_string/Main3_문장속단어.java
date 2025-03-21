package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.Scanner;

/**
 * 문장 속 단어
 */
public class Main3_문장속단어 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(solution(str));
		System.out.println(solution2(str));
	}

	// indexOf와 substring 사용
	private static String solution2(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE, pos;

		while ((pos = str.indexOf(" ")) != -1) {
			String tmp = str.substring(0, pos);

			int len = tmp.length();

			if (len > m) {
				m = len;
				answer = tmp;
			}

			str = str.substring(pos + 1);

			// 마지막 단어는 while문을 돌지않기 때문에 추가 처리 필요
			if (str.length() > m) {
				answer = str;
			}
		}

		return answer;
	}

	// split 후 길이를 비교
	private static String solution(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE;
		String[] s = str.split(" ");

		for (String x : s) {
			int len = x.length();
			if (len > m) {
				m = len;
				answer = x;
			}
		}
		return answer;
	}
}