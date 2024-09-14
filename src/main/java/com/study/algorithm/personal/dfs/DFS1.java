package com.study.algorithm.personal.dfs;

import java.util.Scanner;

public class DFS1 {

	static int n;
	static int[] ch;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		ch = new int[n + 1];
		DFS(1);
	}

	private static void DFS(int L) {
		if (L == n + 1) {
			String tmp = "";
			for (int i = 1; i <= n; i++) {
				if (ch[i] == 1) tmp += (i + " ");
			}
			if (tmp.length() > 0) System.out.println(tmp);
		} else {
			ch[L] = 1;
			DFS(L + 1); // 왼쪽으로 뻗음
			ch[L] = 0;
			DFS(L + 1); // 오른쪽으로 뻗음
		}
	}
}
