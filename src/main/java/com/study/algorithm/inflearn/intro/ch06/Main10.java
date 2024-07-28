package com.study.algorithm.inflearn.intro.ch06;

import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Arrays.sort;

/**
 * 마구간 정하기(결정 알고리즘)
 */
public class Main10 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int c = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		int solution = solution(n, c, arr);
		System.out.println("solution = " + solution);
	}

	static int solution(int n, int c, int[] arr) {
		int answer = 0;
		sort(arr);
		int lt = 1, rt = arr[n - 1];
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(arr, mid) >= c) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}
		return answer;
	}

	static int count(int[] arr, int dist) {
		int cnt = 1;
		int ep = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - ep >= dist) {
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
	}
}
