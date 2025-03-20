package com.study.algorithm.book.doit_middle.ch10_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_13251_조약돌꺼내기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M, K, T;
		int[] D = new int[51];
		double[] probability = new double[51];
		double answer;

		T = 0;
		M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			D[i] = Integer.parseInt(st.nextToken());
			T += D[i];
		}

		K = Integer.parseInt(br.readLine());
		answer = 0.0;

		for (int i = 0; i < M; i++) {
			if (D[i] >= K) {
				probability[i] = 1.0;
				for (int k = 0; k < K; k++) {
					probability[i] *= (double) (D[i] - k) / (T - k);
				}
			}
			answer += probability[i];
		}

		System.out.println(answer);
	}
}