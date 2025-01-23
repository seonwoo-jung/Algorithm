package com.study.algorithm.site.backjoon.step.ch08_일반수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2745 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());

		int result = Integer.parseInt(n, b);
		System.out.println(result);
	}
}
