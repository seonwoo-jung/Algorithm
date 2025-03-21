package com.study.algorithm.site.backjoon.other;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1759 {

	private static char arr[];
	private static boolean[] visited;
	private static int l, c;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		l = kb.nextInt(); // 암호의 수
		c = kb.nextInt(); // 알파벳 수

		arr = new char[c];
		visited = new boolean[c];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = kb.next().charAt(0);
		}

		Arrays.sort(arr);

		DFS(0, 0);
	}

	private static void DFS(int s, int L) {
		if (L == l) {
			String answer = "";
			int a = 0, b = 0;
			for (int i = 0; i < c; i++) {
				if (visited[i]) {
					answer += arr[i];
					if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
						a++;
					} else {
						b++;
					}
				}
			}

			if (a >= 1 && b >= 2) System.out.println(answer);
		} else {
			for (int i = s; i < c; i++) {
				visited[i] = true;
				DFS(i + 1, L + 1);
				visited[i] = false;
			}
		}
	}
}
