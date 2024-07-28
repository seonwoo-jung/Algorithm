package com.study.algorithm.site.programmers.level_0;

public class Main56 {

	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	static int solution(int n) {
		int count = 0;

		for (int i = 1; i <= n; i++) {
			int a = 0;
			for (int j = 1; j <= n; j++) {
				if (i % j == 0) {
					a++;
				}
			}
			if (a >= 3) {
				count++;
			}
		}
		return count;
	}
}