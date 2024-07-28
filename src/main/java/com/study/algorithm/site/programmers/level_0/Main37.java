package com.study.algorithm.site.programmers.level_0;

public class Main37 {

	public static void main(String[] args) {
		int[][] line = {
				{0, 1},
				{2, 5},
				{3, 9}
		};
		System.out.println(solution(line));
	}

	static int solution(int[][] lines) {

		int answer = 0;

		int[] count = new int[201];

		for (int[] i : lines) {
			System.out.println("i = " + i[0]);
			System.out.println("i = " + i[1]);
			int start = i[0] + 100;
			int end = i[1] + 100;

			for (int k = start; k < end; k++) {
				System.out.println("k = " + k);
				System.out.println("end = " + end);
				count[k] += 1;
				System.out.println("count[k] = " + count[k]);
			}
		}

		for (int i : count) {
			if (i > 1) {
				answer++;
			}
		}

		return answer;
	}
}
