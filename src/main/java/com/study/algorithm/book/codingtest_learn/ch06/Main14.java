package com.study.algorithm.book.codingtest_learn.ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 표 편집
 */
public class Main14 {

	public static void main(String[] args) {
		String solution1 = solution2(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
		String solution2 = solution2(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"});
		System.out.println("solution1 = " + solution1);
		System.out.println("solution2 = " + solution2);
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

	private static String solution2(int n, int k, String[] cmd) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		int pointer = k;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < cmd.length; i++) {
			String[] split = cmd[i].split(" ");
			String s = split[0];

			if (s.equals("D")) {
				for (int j = 0; j < Integer.parseInt(split[1]); j++) {
					++pointer;
					if (pointer >= list.size()) {
						pointer = 0;
					}
				}
			} else if (s.equals("U")) {
				for (int j = 0; j < Integer.parseInt(split[1]); j++) {
					--pointer;
					if (pointer < 0) {
						pointer = list.size() - 1;
					}
				}
			} else if (s.equals("C")) {
				stack.push(pointer);
				list.remove(list.indexOf(pointer));
				if (pointer >= list.size()) {
					pointer = 0;
				}

			} else if (s.equals("Z")) {
				if (!stack.isEmpty()) {
					int result = stack.pop();
					list.add(result);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (list.contains(i)) {
				sb.append("O");
			} else {
				sb.append("X");
			}
		}

		return sb.toString();
	}
}
