package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1516_게임개발하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		int[] indegree = new int[N + 1];
		int[] selfBuild = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			selfBuild[i] = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int p = Integer.parseInt(st.nextToken());
				if (p != -1) {
					a.get(p).add(i);
					indegree[i]++;
				}
			}
		}

		Queue<Integer> Q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				Q.offer(i);
			}
		}

		int[] result = new int[N + 1];
		while (!Q.isEmpty()) {
			int now = Q.poll();
			for (int next : a.get(now)) {
				indegree[next]--;
				result[next] = Math.max(result[next], result[now] + selfBuild[now]);
				if (indegree[next] == 0) {
					Q.offer(next);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(result[i] + selfBuild[i]);
		}
	}
}