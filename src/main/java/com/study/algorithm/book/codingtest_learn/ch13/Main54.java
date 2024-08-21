package com.study.algorithm.book.codingtest_learn.ch13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main54 {

	public static void main(String[] args) {
		int[] solution = solution(new int[]{1, 5, 2, 6, 3, 7, 4},
			new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
		System.out.println(Arrays.toString(solution));
	}

	private static int[] solution(int[] array, int[][] commands) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < commands.length; i++) {
			int[] clone = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(clone);
			list.add(clone[commands[i][2] - 1]);
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
