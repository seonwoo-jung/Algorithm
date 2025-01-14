package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 단어 뒤집기
 */
public class Main4_단어뒤집기 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		// 입력 몇 개를 받을 것인지?
		int n = kb.nextInt();

		String[] str = new String[n];

		// n개의 단어를 String 배열에 입력한다.
		for (int i = 0; i < n; i++) {
			str[i] = kb.next();
		}

		System.out.println(solution(n, str));
	}

	private static ArrayList<String> solution(int n, String[] str) {
		ArrayList<String> answer = new ArrayList<>();

		// 1. 단어 전체를 뒤집는 것
//        for (String x : str) {
//            // StringBuilder로 하나의 객체로 연산을 한다.
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }

		// 2. 특정 단어만 뒤집는 것을 직접구현
		for (String x : str) {
			char[] s = x.toCharArray();

			int lt = 0, rt = x.length() - 1;

			while (lt < rt) {
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp;
				lt++;
				rt--;
			}
			String tmp = String.valueOf(s);
			answer.add(tmp);
		}

		return answer;
	}
}