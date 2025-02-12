package com.study.algorithm.site.backjoon.step.ch23_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// DP 적용 (아래에서 위로 올라가면서 최대값을 갱신)
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
			}
		}

		// 정답 출력 (최대 합)
		System.out.println(arr[0][0]);
	}
}