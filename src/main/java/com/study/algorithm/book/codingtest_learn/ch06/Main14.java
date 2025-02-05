package com.study.algorithm.book.codingtest_learn.ch06;

import java.util.Arrays;
import java.util.Stack;

/**
 * 표 편집
 */
public class Main14 {

	public static void main(String[] args) {
		System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
	}

	private static String solution(int n, int k, String[] cmd) {
		Stack<Integer> deleted = new Stack<>();

		int[] up = new int[n + 2];
		int[] down = new int[n + 2];

		for (int i = 0; i < n + 2; i++) {
			up[i] = i - 1;
			down[i] = i + 1;
		}

		System.out.println(Arrays.toString(up));
		System.out.println(Arrays.toString(down));

		k++;

		for (String c : cmd) {
			if (c.startsWith("C")) {
				deleted.push(k);
				up[down[k]] = up[k];
				down[up[k]] = down[k];
				k = n < down[k] ? up[k] : down[k];
			} else if (c.startsWith("Z")) {
				int restore = deleted.pop();
				down[up[restore]] = restore;
				up[down[restore]] = restore;
			} else {
				String[] s = c.split(" ");
				int x = Integer.parseInt(s[1]);
				for (int i = 0; i < x; i++) {
					k = s[0].equals("U") ? up[k] : down[k];
				}
			}
		}

		char[] answer = new char[n];
		Arrays.fill(answer, '0');

		for (int i : deleted) {
			answer[i - 1] = 'X';
		}

		return new String(answer);
	}
}
