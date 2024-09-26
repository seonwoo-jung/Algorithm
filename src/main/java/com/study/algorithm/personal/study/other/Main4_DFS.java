package com.study.algorithm.personal.study.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;
import static java.lang.System.in;

public class Main4_DFS {

	static int n, m, answer = MIN_VALUE;
	static List<Score> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);

		n = kb.nextInt();
		m = kb.nextInt();

		for (int i = 0; i < n; i++) {
			int s = kb.nextInt();
			int t = kb.nextInt();
			list.add(new Score(s, t));
		}

		DFS(0, 0, m);
		System.out.println("answer = " + answer);
	}

	private static void DFS(int L, int sum, int m) {
		if (m < 0) return;
		if (L == n) {
			answer = max(answer, sum);
		} else {
			DFS(L + 1, sum + list.get(L).score, m - list.get(L).time);
			DFS(L + 1, sum, m);
		}
	}

	static class Score {
		private int score, time;

		public Score(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}
}