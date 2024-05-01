package com.study.algorithm.programmers.level_1;

import java.util.ArrayList;
import java.util.List;

public class Main23 {

	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5213123;
		int[] solution = solution(arr, divisor);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}

		return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).sorted().toArray();
	}
}
