package com.study.algorithm.inflearn.intro.ch04_hash;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 학급 회장 (해쉬)
 */
public class Main1_학급회장 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(in);
		int a = stdIn.nextInt();
		String b = stdIn.next();
		System.out.println(solution(a, b));
	}

	private static char solution(int a, String b) {

		char answer = ' ';
		HashMap<Character, Integer> map = new HashMap<>();

		for (char x : b.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		int max = MIN_VALUE;

		for (char key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				answer = key;
			}
		}

		return answer;
	}
}
