package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj_28279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> Q = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			switch (s.charAt(0) - 48) {
				case 1: {
					Q.offerFirst(Integer.parseInt(s.split(" ")[1]));
					break;
				}

				case 2: {
					Q.offerLast(Integer.parseInt(s.split(" ")[1]));
					break;
				}

				case 3: {
					Integer k = Q.pollFirst();
					sb.append(k == null ? -1 : k).append("\n");
					break;
				}

				case 4: {
					Integer k = Q.pollLast();
					sb.append(k == null ? -1 : k).append("\n");
					break;
				}

				case 5:
					sb.append(Q.size()).append("\n");
					break;

				case 6:
					sb.append(Q.isEmpty() ? 1 : 0).append("\n");
					break;

				case 7: {
					Integer k = Q.peekFirst();
					sb.append(k == null ? -1 : k).append("\n");
					break;
				}

				case 8: {
					Integer k = Q.peekLast();
					sb.append(k == null ? -1 : k).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}