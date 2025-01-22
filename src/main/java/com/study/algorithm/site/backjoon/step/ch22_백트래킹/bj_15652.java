package com.study.algorithm.site.backjoon.step.ch22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_15652 {

	private static int[] combi, ch;
	private static int N, M;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 1부터 N까지 수열
		M = Integer.parseInt(st.nextToken()); // 수열 길이
		sb = new StringBuilder();
		combi = new int[M];
		ch = new int[N + 1];

		DFS(0, 1);
		System.out.println(sb.toString());
	}

	private static void DFS(int L, int s) {
		if (L == M) {
			for (int j : combi) {
				sb.append(j).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = s; i <= N; i++) {
				combi[L] = i;
				DFS(L + 1, i);
			}
		}
	}
}