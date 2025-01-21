package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj_2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> Q = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			Q.offerLast(i);
		}

		while (Q.size() > 1) {
			Q.pollFirst();
			int m = Q.pollFirst();
			Q.addLast(m);
		}
		System.out.println(Q.poll());
	}
}