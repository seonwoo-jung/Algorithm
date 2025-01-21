package com.study.algorithm.site.backjoon.step.ch19_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_15439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(n * n - n);
	}
}