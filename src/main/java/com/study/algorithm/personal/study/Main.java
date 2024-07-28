package com.study.algorithm.personal.study;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int answer = Integer.MAX_VALUE;
	static int[] dis = {1, -1, 5};
	static int[] ch;
	static Queue<Integer> Q = new LinkedList<>();

	public static void main(String[] args) {
		int s = 5;
		int e = 14;
		ch = new int[100001];
		ch[s] = 1;
		DFS(0, s, e);
	}

	static void DFS(int L, int s, int e) {
		if (s == e) {
			answer = Math.min(answer, L);
		} else {
			for (int i = 0; i < dis.length; i++) {
				int nx = s + dis[i];
				if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
					ch[nx] = 1;
					DFS(L + 1, nx, e);
				}
			}
		}
	}

	// 인강에서 푼 방법
	static int BFS1(int s, int e) {
		ch = new int[100001];
		ch[s] = 1;
		Q.offer(s);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll();
				if (x == e) return L;
				for (int j = 0; j < dis.length; j++) {
					int nx = x + dis[j];
					if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return L;
	}

	static int BFS2(int s, int e) {
		ch = new int[100001];
		ch[s] = 1;
		Q.offer(s);
		int L = 0;
		while (!Q.isEmpty()) {
			int x = Q.poll();
			if (x == e) return L;
			for (int j = 0; j < dis.length; j++) {
				int nx = x + dis[j];
				if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
					ch[nx] = 1;
					Q.offer(nx);
				}
			}
			L++;
		}
		return L;
	}
}