package com.study.algorithm.site.programmers.level_0;

public class Main74 {

	public static void main(String[] args) {
		int[] num_list = {1, 2, 3, 4, 5};
		solution(num_list);
	}

	static int[] solution(int[] num_list) {
		int[] reverse = new int[num_list.length];

		for (int i = 0; i < num_list.length; i++) {
			reverse[i] = num_list[num_list.length - 1 - i];
		}

		return reverse;
	}
}