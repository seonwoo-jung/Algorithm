package com.study.algorithm.site.backjoon.step.ch21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_4779 {

	private static int n;
	private static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String str;

		while ((str = br.readLine()) != null) {
			n = Integer.parseInt(str);
			sb = new StringBuilder();

			int len = (int) Math.pow(3, n);

			arr = new char[len];
			Arrays.fill(arr, '-');

			func(0, len);

			for (char x : arr) {
				sb.append(x);
			}

			System.out.println(sb.toString());
		}
	}

	private static void func(int start, int size) {
		if (size <= 1) {
			return;
		}

		// 3등분으로 쪼개기 위한 변수 값
		int newSize = size / 3;

		// 가운데 부분 공백으로 바꾸기
		for (int i = start + newSize; i < start + 2 * newSize; i++) {
			arr[i] = ' ';
		}

		func(start, newSize); // 첫번 째 구역 쪼개기
		func(start + 2 * newSize, newSize); // 세번 째 구역 쪼개기
	}
}