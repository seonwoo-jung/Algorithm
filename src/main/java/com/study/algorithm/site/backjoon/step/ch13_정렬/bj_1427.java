package com.study.algorithm.site.backjoon.step.ch13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class bj_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split("");
		Integer[] answer = new Integer[s.length];

		for (int i = 0; i < s.length; i++) {
			answer[i] = Integer.parseInt(s[i]);
		}

		Arrays.sort(answer, Collections.reverseOrder());

		for (int x : answer) {
			System.out.printf("%d", x);
		}
	}
}