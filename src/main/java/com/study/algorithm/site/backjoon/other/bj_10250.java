package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_10250 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 행
			int W = Integer.parseInt(st.nextToken()); // 열
			int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님인지

			int floor = N % H;
			int room = N / H + 1;

			if (floor == 0) {
				floor = H;
				room -= 1;
			}

			System.out.println(floor * 100 + room);
		}
	}
}
