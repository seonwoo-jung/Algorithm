package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2251_물의양구하기 {

	private static final int[] sender = {0, 0, 1, 1, 2, 2};
	private static final int[] receiver = {1, 2, 0, 2, 0, 1};
	private static boolean[][] visited;
	private static boolean[] answer;
	private static int[] now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		now = new int[3];
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());
		visited = new boolean[201][201];
		answer = new boolean[201];

		BFS();

		for (int i = 0; i < answer.length; i++) {
			if (answer[i]) {
				System.out.print(i + " ");
			}
		}
	}

	private static void BFS() {
		Queue<AB> Q = new LinkedList<>();
		Q.offer(new AB(0, 0));
		visited[0][0] = true;
		answer[now[2]] = true;

		while (!Q.isEmpty()) {
			AB p = Q.poll();
			int A = p.A;
			int B = p.B;
			int C = now[2] - A - B;
			for (int i = 0; i < 6; i++) {
				int[] next = {A, B, C};
				next[receiver[i]] += next[sender[i]];
				next[sender[i]] = 0;

				// 받는 물통이 넘칠 때
				if (next[receiver[i]] > now[receiver[i]]) {
					next[sender[i]] = next[receiver[i]] - now[receiver[i]];
					next[receiver[i]] = now[receiver[i]];
				}

				// 방문하지 않은 노드
				if (!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					Q.offer(new AB(next[0], next[1]));
					if (next[0] == 0) {
						answer[next[2]] = true;
					}
				}
			}
		}
	}

	private static class AB {

		int A, B;

		public AB(int a, int b) {
			A = a;
			B = b;
		}
	}
}