package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_31403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		System.out.println((A + B) - C);
		System.out.println(Integer.parseInt(A + "" + B) - C);
	}
}
