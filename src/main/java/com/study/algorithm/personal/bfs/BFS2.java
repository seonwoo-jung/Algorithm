package com.study.algorithm.personal.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.in;

public class BFS2 {

	static int[] dis = {1, -1, 5};
	static int[] ch;
	static Queue<Integer> Q = new LinkedList<>();
	int answer = 0;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int s = kb.nextInt();
		int e = kb.nextInt();
		int bfs = BFS(s, e);
		System.out.println("bfs = " + bfs);
	}

	private static int BFS(int s, int e) {
		ch = new int[10001];
		ch[s] = 1; // 출발지점
		Q.offer(s);
		int L = 0;

		while (!Q.isEmpty()) {
			int len = Q.size();
			// for문 i가 끝나면 같은 레벨을 모두 탐색한 것
			for (int i = 0; i < len; i++) {
				int x = Q.poll();
				for (int j = 0; j < dis.length; j++) {
					int nx = x + dis[j];
					if (nx == e) return L + 1;
					if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
						ch[nx] = 1; // 방문한 것은 체크한다.
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return L;
	}
}
