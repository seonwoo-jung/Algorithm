package com.study.algorithm.site.backjoon.step.ch24_누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_10986_나머지합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[] sum = new int[N + 1];
		int[] cnt = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
			if (sum[i] == 0) {
				answer++;
			}
			cnt[sum[i]]++;
		}

		for (int i = 0; i < M; i++) {
			if (cnt[i] > 1) {
				answer += (cnt[i] * (cnt[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}
}