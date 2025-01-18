package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_25305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str.split(" ")[0]);
		int k = Integer.parseInt(str.split(" ")[1]);

		int[] answer = new int[n];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			answer[i] = Integer.parseInt(s[i]);
		}

		Arrays.sort(answer);

		System.out.println(answer[n - k]);
	}
}