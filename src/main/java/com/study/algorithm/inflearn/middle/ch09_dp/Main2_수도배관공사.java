package com.study.algorithm.inflearn.middle.ch09_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2_수도배관공사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] dy = new int[D + 1];

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken()); // 수도관 길이
			int C = Integer.parseInt(st.nextToken()); // 수도관 용량

			// 파이프는 한번만 사용할 수 있기 때문에 오른쪽에서 왼쪽으로 이동
			for (int j = D; j > L; j--) {
				if (dy[j - L] == 0) continue;
				dy[j] = Math.max(dy[j], Math.min(dy[j - L], C));
			}
			dy[L] = Math.max(dy[L], C);
		}
		System.out.println(dy[D]);
	}
}
