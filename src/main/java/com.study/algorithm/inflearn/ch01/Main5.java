package com.study.algorithm.inflearn.ch01;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.util.regex.Pattern.matches;

public class Main5 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);

		// 입력 몇 개를 받을 것인지?
		int n = kb.nextInt();

		String[] str = new String[n];

		// n개의 단어를 String 배열에 입력한다.
		for (int i = 0; i < n; i++) {
			str[i] = kb.next();
		}

		System.out.println(solution(n, str));
		System.out.println(solution2("a#b!GE*T@S"));
	}

	static ArrayList<String> solution(int n, String[] str) {
		ArrayList<String> answer = new ArrayList<>();
		for (String x : str) {
			char[] s = x.toCharArray();
			int lt = 0, rt = x.length() - 1;
			while (lt < rt) {
				String pattern = "^[a-zA-Z]*$";
				if (matches(pattern, String.valueOf(s[lt])) && matches(pattern, String.valueOf(s[rt]))) {
					char tmp = s[lt];
					s[lt] = s[rt];
					s[rt] = tmp;
				}
				lt++;
				rt--;
			}
			String tmp = String.valueOf(s);
			answer.add(tmp);
		}

		return answer;
	}

	static String solution2(String str) {
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