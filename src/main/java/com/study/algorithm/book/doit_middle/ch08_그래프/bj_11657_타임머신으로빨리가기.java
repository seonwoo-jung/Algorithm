package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_11657_타임머신으로빨리가기 {

	private static int[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[M + 1];
		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(s, e, time);
		}

		dis[1] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = edges[j];
				if (dis[edge.start] != Integer.MAX_VALUE && dis[edge.end] > dis[edge.start] + edge.time) {
					dis[edge.end] = dis[edge.start] + edge.time;
				}
			}
		}

		boolean mCycle = false;
		for (int i = 0; i < M; i++) {
			Edge edge = edges[i];
			if (dis[edge.start] != Integer.MAX_VALUE && dis[edge.end] > dis[edge.start] + edge.time) {
				mCycle = true;
			}
		}

		if (!mCycle) {
			for (int i = 2; i <= N; i++) {
				if (dis[i] == Integer.MAX_VALUE) {
					System.out.println("-1");
				} else {
					System.out.println(dis[i]);
				}
			}
		} else {
			System.out.println("-1");
		}
	}

	private static class Edge {
		int start, end, time;

		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
}
