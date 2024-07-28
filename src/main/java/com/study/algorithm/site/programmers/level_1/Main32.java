package com.study.algorithm.site.programmers.level_1;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main32 {

	public static void main(String[] args) {
		int[][] arr = {
				{60, 50},
				{30, 70},
				{60, 30},
				{80, 40}
		};
		int solution = solution(arr);

		System.out.println("solution = " + solution);
	}

	static int solution(int[][] sizes) {

		int[][] answer = new int[sizes.length][2];
		int w = MIN_VALUE, h = MIN_VALUE;

		for (int i = 0; i < sizes.length; i++) {
			answer[i][0] = max(sizes[i][0], sizes[i][1]);
			answer[i][1] = min(sizes[i][0], sizes[i][1]);
			w = Math.max(w, answer[i][0]);
			h = Math.max(h, answer[i][1]);
		}
		return w * h;
	}
}