package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());

		if (N == 4 || N == 7) { // N이 4이거나 7일 경우에는 3이나 5로 나눌수 없다.
			System.out.println(-1);
		} else if (N % 5 == 0) { // N이 5로 바로 나눠질 경우
			System.out.println(N / 5);
		} else if (N % 5 == 1 || N % 5 == 3) { // N이 6, 8, 11, 13, 16 등일 경우
			System.out.println((N / 5) + 1);
		} else if (N % 5 == 2 || N % 5 == 4) { // N이 9, 12, 14, 17, 19 등일 경우
			System.out.println((N / 5) + 2);
		}
	}
}