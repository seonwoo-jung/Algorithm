package com.study.algorithm.site.programmers.level_0;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

// 이해안됨
public class Main47 {

	public static void main(String[] args) {
		int[][] array = {
				{1, 1},
				{2, 1},
				{2, 2},
				{1, 2}
		};

		// result: 1
		System.out.println(solution(array));
	}

	private static int solution(int[][] dots) {

		int x1 = 0;
		int y1 = 0;

		for (int i = 1; i < 4; i++) {
			if ((dots[0][0] != dots[i][0]) && (dots[0][1] != dots[i][1])) {
				x1 = dots[i][0];
				y1 = dots[i][1];
				break;
			}
		}

		int xdistance = (int) sqrt((int) (pow(dots[0][0] - x1, 2)));
		int ydistance = (int) sqrt((int) (pow(dots[0][1] - y1, 2)));

		return xdistance * ydistance;
	}
}