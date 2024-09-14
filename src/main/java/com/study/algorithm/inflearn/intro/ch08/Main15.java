package com.study.algorithm.inflearn.intro.ch08;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.System.in;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 피자배달거리
 */
public class Main15 {

	static int n, m, len, answer = MAX_VALUE;
	static int[] combi;
	static ArrayList<Point> house, pizza;

	private static void DFS(int L, int s) {
		if (L == m) {
			int sum = 0;
			for (Point h : house) {
				int dis = MAX_VALUE;
				for (int i : combi) {
					dis = min(dis, abs(h.x - pizza.get(i).x) + abs(h.y - pizza.get(i).y));
				}
				sum += dis;
			}
			answer = min(answer, sum);
		} else {
			for (int i = s; i < len; i++) {
				combi[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
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

	private static class Point {

		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}