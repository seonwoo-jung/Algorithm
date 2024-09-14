package com.study.algorithm.inflearn.intro.ch03;

import static java.lang.Math.max;
import static java.lang.System.in;

import java.util.Scanner;

/**
 * 최대 길이 연속부분수열
 */
public class Main7 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		int solution = solution(n, k, arr);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n, int k, int[] arr) {
		int answer = 0, cnt = 0, lt = 0;
		for (int rt = 0; rt < n; rt++) {

			if (arr[rt] == 0) {
				cnt++;
			}

			while (cnt > k) {
				if (arr[lt] == 0) {
					cnt--;
				}
				lt++;
				answer = max(answer, rt - lt + 1);
			}

		}
		return answer;
	}
}