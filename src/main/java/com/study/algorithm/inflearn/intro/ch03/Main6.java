package com.study.algorithm.inflearn.intro.ch03;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 연속된 자연수의 합 (수학)
 */
public class Main6 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int solution = solution(n);
		System.out.println("solution = " + solution);
	}

	static int solution(int n) {
		int answer = 0, cnt = 1;
		n--; // 15 -> 14
		while (n > 0) {
			cnt++;       // 2  -> 3 -> 4 -> 5
			n = n - cnt; // 12 -> 9 -> 5 -> 0
			if (n % cnt == 0) answer++;
		}
		return answer;
	}
}