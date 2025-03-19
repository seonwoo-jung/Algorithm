package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		int[] indegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a.get(s).add(e);
			indegree[e]++;
		}

		Queue<Integer> Q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				Q.offer(i);
			}
		}

		while (!Q.isEmpty()) {
			Integer now = Q.poll();
			System.out.print(now + " ");
			for (int next : a.get(now)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					Q.offer(next);
				}
			}
		}
	}
}