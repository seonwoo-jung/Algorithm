package com.study.algorithm.inflearn.middle.ch09_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1_사탕가게 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);

			if (n == 0 && m == 0) break;
			int[] dy = new int[m + 1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int p = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
				for (int j = p; j <= m; j++) {
					dy[j] = Math.max(dy[j], dy[j - p] + c);
				}
			}
			System.out.println(dy[m]);
		}
	}
}
