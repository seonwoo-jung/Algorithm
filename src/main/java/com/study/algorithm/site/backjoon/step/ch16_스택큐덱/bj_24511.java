package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj_24511 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] typeArr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			typeArr[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> deque = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (typeArr[i] == 0) {
				deque.addLast(num);
			}
		}

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		while (M --> 0) {
			int moveValue = Integer.parseInt(st.nextToken());
			deque.addFirst(moveValue);
			sb.append(deque.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}