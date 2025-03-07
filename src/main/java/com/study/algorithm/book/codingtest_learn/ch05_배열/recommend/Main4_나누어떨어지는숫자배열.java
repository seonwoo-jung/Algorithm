package com.study.algorithm.book.codingtest_learn.ch05_배열.recommend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4_나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
		System.out.println(Arrays.toString(solution(new int[]{2, 36, 1, 3}, 1)));
		System.out.println(Arrays.toString(solution(new int[]{3, 2, 6}, 10)));
	}

	private static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}

		return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).sorted().toArray();
	}
}
