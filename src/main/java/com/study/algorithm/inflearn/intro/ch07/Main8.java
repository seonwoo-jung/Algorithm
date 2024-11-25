package com.study.algorithm.inflearn.intro.ch07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 송아지 찾기1(BFS)
 */
public class Main8 {

	private static int[] dis = {1, -1, 5};
	private static Queue<Integer> Q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int s = kb.nextInt(); // 현수 위치
		int e = kb.nextInt(); // 송아지 위치
		System.out.println(solution2(s, e));
	}

	private static int solution2(int s, int e) {
		Q.offer(s);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll();
				for (int j = 0; j < 3; j++) {
					int nx = x + dis[j];
					if (nx == e) return L + 1;
						Q.offer(nx);
				}
			}
			L++;
		}
		return L;
	}
}
