package com.study.algorithm.site.programmers.level_0;

import static java.lang.Math.abs;
import static java.util.stream.IntStream.of;

public class Main35 {

	public static void main(String[] args) {
		int[] numlist = {1, 2, 3, 4, 5};
		int n = 4;
		solution(numlist, n);
	}

	private static int[] solution(int[] numlist, int n) {
		return of(numlist).boxed().sorted((o1, o2) -> {
					int o1Abs = abs(o1 - n);
					int o2Abs = abs(o2 - n);

					if (o1Abs == o2Abs) {
						if (o1 > o2) return -1;
						else if (o1 < o2) return 1;
					} else {
						return o1Abs - o2Abs;
					}

					return 0;
				}).mapToInt(Integer::intValue)
				.toArray();
	}
}
