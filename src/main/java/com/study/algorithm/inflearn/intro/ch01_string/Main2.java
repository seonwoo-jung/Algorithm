package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 대소문자 변환
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		String str = kb.next();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		String answer = "";

		for (char x : str.toCharArray()) {
			// 소문자일 경우 대문자로 변경
			if (x >= 97 && x <= 122) {
				answer += (char) (x - 32);
			} else {
				answer += (char) (x + 32);
			}
		}

		// 대문자는 아스키 기준 65 ~ 90
		// 소문자는 아스키 기준 97 ~ 122
//        // 소문자 + 32 -> 대문자
//        for (char x : str.toCharArray()) {
//            if (Character.isLowerCase(x)) {
//                answer += Character.toUpperCase(x);
//            } else {
//                answer += Character.toLowerCase(x);
//            }
//        }
		return answer;
	}
}
