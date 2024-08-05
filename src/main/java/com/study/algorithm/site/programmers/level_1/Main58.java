package com.study.algorithm.site.programmers.level_1;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 둘만의 암호
 */
public class Main58 {

	public static void main(String[] args) {
		System.out.println(solution("aukks", "wbqd", 5));
		System.out.println(solution("ybc", "az", 1));
	}

	public static String solution(String s, String skip, int index) {
		Set<Character> skips = new HashSet<>();
		for (char x : skip.toCharArray()) {
			skips.add(x);
		}

		char[] array = s.toCharArray();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < index; j++) {
				do {
					array[i]++;
					if (array[i] > 'z') {
						array[i] -= 26;  // 알파벳이 'z'를 넘어가면 'a'로 돌아감
					}
				} while (skips.contains(array[i]));  // 스킵 문자일 경우 다시 증가시킴
			}
		}

		return new String(array);
	}
}
