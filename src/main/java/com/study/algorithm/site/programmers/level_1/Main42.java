package com.study.algorithm.site.programmers.level_1;

import static java.lang.Character.*;

public class Main42 {
	public static void main(String[] args) {
		String s = "try hello world";
		StringBuilder sb = new StringBuilder();

		int idx = 0;

		for (int i = 0; i < s.length(); i++) {
			if (isAlphabetic(s.charAt(i))) {
				if (idx % 2 == 0) {
					sb.append(toUpperCase(s.charAt(i)));
				} else {
					sb.append(toLowerCase(s.charAt(i)));
				}
				idx++;
			} else {
				sb.append(s.charAt(i));
				idx = 0;
			}
		}

		System.out.println(sb.toString());
	}
}