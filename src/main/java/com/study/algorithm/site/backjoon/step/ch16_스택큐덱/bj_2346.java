package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj_2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<int[]> Q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] balloonLocation = new int[N];

		for (int i = 0; i < N; i++) {
			balloonLocation[i] = Integer.parseInt(st.nextToken());
		}

		sb.append("1 ");
		int moveValue = balloonLocation[0];

		for (int i = 1; i < N; i++) {
			Q.offer(new int[]{i + 1, balloonLocation[i]});
		}

		while (!Q.isEmpty()) {
			if (moveValue > 0) {
				for (int i = 1; i < moveValue; i++) {
					Q.offer(Q.poll());
				}
				int[] next = Q.poll();
				moveValue = next[1];
				sb.append(next[0]).append(" ");
			} else {
				for (int i = 1; i < -moveValue; i++) {
					Q.offerFirst(Q.pollLast());
				}
				int[] next = Q.pollLast();
				moveValue = next[1];
				sb.append(next[0]).append(" ");
			}
		}

		System.out.println(sb);
	}
}