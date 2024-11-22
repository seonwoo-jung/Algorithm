package com.study.algorithm.inflearn.intro.ch10;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.System.in;

/**
 * 최대 부분 증가수열(LIS)
 */
public class Main3 {

	private static int[] dy;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);

		int n = kb.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) arr[i] = kb.nextInt();

		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int answer = 0;
		dy = new int[arr.length];
		dy[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			int max = 0;

			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j] && dy[j] > max) {
					max = dy[j];
				}
				dy[i] = max + 1;
				answer = max(answer, dy[i]);
			}
		}
		return answer;
	}
}
