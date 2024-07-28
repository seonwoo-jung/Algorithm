package com.study.algorithm.site.programmers.level_1;

import java.util.ArrayList;
import java.util.List;

public class Main49 {

	public static void main(String[] args) {
		int n = 3;
		int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] solution = solution(n, numlist);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int n, int[] numlist) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numlist.length; i++) {
			if (numlist[i] % n == 0) {
				list.add(numlist[i]);
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}