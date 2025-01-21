package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj_18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<Integer> Q = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			switch (s.charAt(0)) {
				case 'p':
					if (s.length() == 3) {
						Integer k = Q.pollFirst();
						bw.write((k == null ? -1 : k) + "\n");
					} else {
						Q.offer(Integer.parseInt(s.substring(5)));
					}
					break;
				case 's':
					bw.write(Q.size() + "\n");
					break;
				case 'e':
					bw.write((Q.isEmpty() ? 1 : 0) + "\n");
					break;
				case 'f': {
					Integer k = Q.peekFirst();
					bw.write((k == null ? -1 : k) + "\n");
					break;
				}
				case 'b': {
					Integer k = Q.peekLast();
					bw.write((k == null ? -1 : k) + "\n");
					break;
				}
			}
		}
		bw.flush();
	}
}