package com.study.algorithm.personal.study;

import java.util.*;

public class Main37 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{0,1,2,3,4,5}, new int[]{4,1,2})));
	}

	private static int[] solution(int[] arr, int[] query) {
		List<Integer> list = new LinkedList<>();

		for (int i : arr) {
			list.add(i);
		}

		for (int i = 0; i < query.length; i++) {
			if (query[i] % 2 == 0) {
				for (int j = query[i] + 1; j <= list.size(); j++) {
					list.remove(j);
				}
			} else {
				for (int j = 0; j < query[i]; j++) {
					list.remove(j);
				}
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
