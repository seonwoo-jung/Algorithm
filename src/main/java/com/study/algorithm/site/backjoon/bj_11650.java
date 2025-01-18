package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_11650 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] answer = new int[n][2];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			answer[i][0] = Integer.parseInt(s.split(" ")[0]);
			answer[i][1] = Integer.parseInt(s.split(" ")[1]);
		}

		Arrays.sort(answer, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		for (int[] p : answer) {
			sb.append(String.format("%d %d\n", p[0], p[1]));
		}

		System.out.println(sb.toString());
	}
}