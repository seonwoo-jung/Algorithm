package com.study.algorithm.inflearn.ch01;

import java.util.Scanner;

import static java.lang.System.in;

public class Main6 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		// input: ksekkset
		// output: kset
		System.out.println(solution2(kb.nextLine()));
	}

	static String solution(String str) {
		char[] tmp = str.toCharArray();
		for (int i = 0; i < tmp.length - 2; i++) {
			for (int j = i + 1; j < tmp.length - 1; j++) {
				if (tmp[i] == tmp[j]) {
					tmp[j] = ' ';
				}
			}
		}
		return String.valueOf(tmp).replaceAll(" ", "");
	}

	// indexOf는 문자열에서 첫 번째 문자 위치를 찾는다.
	static String solution2(String str) {
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(str.charAt(i)) == i) {
				answer += str.charAt(i);
			}
		}
		return answer;
	}
}