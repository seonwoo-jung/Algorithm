package com.study.algorithm.inflearn.intro.ch08_dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 피자배달거리
 */
public class Main15_피자배달거리 {

	private static int n, m, len, answer = Integer.MAX_VALUE;
	private static int[] combi;
	private static ArrayList<Point> house, pizza;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();

		pizza = new ArrayList<>();
		house = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = kb.nextInt();
				if (tmp == 1) {
					house.add(new Point(i, j));
				} else if (tmp == 2) {
					pizza.add(new Point(i, j));
				}
			}
		}

		len = pizza.size();
		combi = new int[m];
		DFS(0, 0);
		System.out.println(answer);
	}

	private static void DFS(int L, int s) {
		if (L == m) {
			int sum = 0;
			for (Point h : house) {
				int dis = Integer.MAX_VALUE;
				for (int i : combi) {
					dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
				}
				sum += dis;
			}
			answer = Math.min(answer, sum);
		} else {
			for (int i = s; i < len; i++) {
				combi[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}

	private static class Point {

		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}