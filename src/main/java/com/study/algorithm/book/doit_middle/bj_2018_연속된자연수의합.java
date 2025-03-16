package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2018_연속된자연수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int lt = 1, rt = 1, answer = 1;
		int sum = 0;

		while (rt != N) {
			if (sum < N) {
				sum += rt++;
			} else if (sum > N) {
				sum -= lt++;
			} else {
				answer++;
				sum -= lt++;
			}
		}
		System.out.println(answer);
	}
}
