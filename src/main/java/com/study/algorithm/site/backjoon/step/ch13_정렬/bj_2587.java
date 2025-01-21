package com.study.algorithm.site.backjoon.step.ch13_정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_2587 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 5;
		int[] answer = new int[n];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(answer);

		int mid = answer[answer.length / 2];
		int floor = (int) Arrays.stream(answer).average().getAsDouble();

		System.out.println(floor);
		System.out.println(mid);
	}
}