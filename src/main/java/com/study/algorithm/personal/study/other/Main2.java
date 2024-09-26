package com.study.algorithm.personal.study.other;

import java.util.LinkedList;
import java.util.Queue;

public class Main2 {

	static String answer = "NO";
	static int n, total;
	static boolean flag = false;
	static int[] arr;

	public static void main(String[] args) {
		arr = new int[]{1, 3, 5, 6, 7, 10};
		n = 6;

		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}

		String bfs = BFS(0);
		System.out.println("bfs = " + bfs);
	}

	private static String BFS(int L) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(arr[0]);

		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int tmp = Q.poll();
				for (int j = 0; j < arr.length; j++) {
					if (total - tmp == tmp) {
						answer = "YES";
						return "YES";
					} else {
						Q.offer(tmp + arr[j]);
					}
				}
			}
			L++;
		}
		return "YES";
	}

	private static void DFS(int L, int sum) {

		if (flag) return;

		if (sum > total) return;

		if (L == arr.length) {
			if ((total - sum) == sum) {
				answer = "YES";
				flag = true;
			}

		} else {
			DFS(L + 1, sum + arr[L]);
			DFS(L + 1, sum);
		}
	}

}