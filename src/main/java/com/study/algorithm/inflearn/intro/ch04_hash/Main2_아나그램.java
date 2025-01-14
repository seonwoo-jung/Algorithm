package com.study.algorithm.inflearn.intro.ch04_hash;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 아나그램 (해쉬)
 */
public class Main2_아나그램 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String a = stdIn.next();
		String b = stdIn.next();
		String solution = solution(a, b);
		System.out.println("solution = " + solution);
	}

	private static String solution(String s1, String s2) {
		String answer = "YES";
		HashMap<Character, Integer> map = new HashMap<>();
		for (char x : s1.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		for (char x : s2.toCharArray()) {
			// 키가 존재하지 않거나 값이 0일 경우
			if (!map.containsKey(x) || map.get(x) == 0) {
				return "NO";
			}
			map.put(x, map.get(x) - 1);
		}
		return answer;
	}
}
