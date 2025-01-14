package com.study.algorithm.personal.dfs;

import java.util.Scanner;

import static java.lang.System.in;

// 순열구하기
public class DFS12 {

	static int[] pm, ch, arr;
	static int n, m;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		ch = new int[n];
		pm = new int[m];
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		DFS(0);
	}

	private static void DFS(int L) {
		if (L == m) {
			for (int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					pm[L] = arr[i];
					DFS(L + 1);
					ch[i] = 0;
				}
			}
		}

//        // 내 방식
//        if (L == 2) {
//            for (int i = 0; i < pm.length; i++) {
//                if (pm[i] != 0) {
//                    System.out.printf("%d ", pm[i]);
//                }
//            }
//            System.out.println();
//        } else {
//            for (int i = 0; i < n; i++) {
//                pm[L] = arr[i];
//                DFS(L + 1, arr);
//                pm[L] = 0;
//            }
//        }
	}
}