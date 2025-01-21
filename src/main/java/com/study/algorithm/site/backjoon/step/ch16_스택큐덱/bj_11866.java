package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class bj_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> answer = new ArrayList<>();
		String[] s = br.readLine().split(" ");

		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		Deque<Integer> Q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			Q.offer(i);
		}

		while (Q.size() > 1) {
			for (int i = 0; i < m - 1; i++) {
				Q.offer(Q.poll());
			}
			answer.add(Q.poll());
		}
		answer.add(Q.poll());
		System.out.println(answer.toString().replaceAll("\\[", "<").replaceAll("]", ">"));
	}
}